package com.example.transparencia;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transparencia.adapter.PartidosAdapter;
import com.example.transparencia.controller.PartidoController;
import com.example.transparencia.model.Partido;

import java.util.ArrayList;
import java.util.List;

public class ListaPartidosActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPartidos;
    private PartidosAdapter adapter;
    private PartidoController partidoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partidos);

        recyclerViewPartidos = findViewById(R.id.recyclerViewPartidos);
        adapter = new PartidosAdapter(this, new ArrayList<>());
        recyclerViewPartidos.setAdapter(adapter);
        recyclerViewPartidos.setLayoutManager(new LinearLayoutManager(this));

        partidoController = new PartidoController();
        buscarPartidos();
    }

    private void buscarPartidos() {
        partidoController.getPartidos(new PartidoController.PartidosListener() {
            @Override
            public void onPartidosReceived(List<Partido> partidos) {
                runOnUiThread(() -> {
                    adapter.setPartidos(partidos);
                });
            }

            @Override
            public void onError(String message) {
                System.out.println("Erro ao buscar partidos: " + message);
            }
        });
    }
}
