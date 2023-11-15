package com.example.transparencia;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.transparencia.adapter.DeputadosAdapter;
import com.example.transparencia.controller.DeputadoController;
import com.example.transparencia.model.Deputado;

import java.util.ArrayList;
import java.util.List;

public class ListaDeputadosActivity extends AppCompatActivity {
    private RecyclerView recyclerViewDeputados;
    private DeputadosAdapter adapter;
    private List<Deputado> listaDeputados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deputados);

        recyclerViewDeputados = findViewById(R.id.recyclerViewDeputados);
        adapter = new DeputadosAdapter(this, listaDeputados);
        recyclerViewDeputados.setAdapter(adapter);
        recyclerViewDeputados.setLayoutManager(new LinearLayoutManager(this));

        buscarDeputados();
    }

    private void buscarDeputados() {
        DeputadoController deputadoController = new DeputadoController();
        deputadoController.getDeputados(new DeputadoController.DeputadosListener<Deputado>() {
            @Override
            public void onDeputadosReceived(List<Deputado> deputados) {
                runOnUiThread(() -> {
                    listaDeputados.clear();
                    listaDeputados.addAll(deputados);
                    adapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onError(String message) {
                // Tratar erros aqui, talvez mostre uma mensagem ao usuário
            }
        });
    }

}

