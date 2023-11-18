package com.example.transparencia;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.transparencia.adapter.DeputadosAdapter;
import com.example.transparencia.controller.DeputadoController;
import com.example.transparencia.model.Deputado;

import java.util.ArrayList;
import java.util.List;

public class ListaDeputadosActivity extends AppCompatActivity implements DeputadosAdapter.ItemClickListener {
    private RecyclerView recyclerViewDeputados;
    private DeputadosAdapter adapter;
    private List<Deputado> listaDeputados = new ArrayList<>();
    private EditText searchEditText;
    private TextView tvNoDeputados;

    private DeputadoController deputadoController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deputados);

        recyclerViewDeputados = findViewById(R.id.recyclerViewDeputados);
        searchEditText = findViewById(R.id.searchEditText);
        tvNoDeputados = findViewById(R.id.tvNoDeputados);

        adapter = new DeputadosAdapter(this, listaDeputados);
        recyclerViewDeputados.setAdapter(adapter);
        recyclerViewDeputados.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);

        deputadoController = new DeputadoController();

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 3) {
                    deputadoController.buscarDeputadosPorNome(s.toString(), new DeputadoController.DeputadosListener<Deputado>() {
                        @Override
                        public void onDeputadosReceived(List<Deputado> deputados) {
                            adapter.filterList(deputados);
                        }

                        @Override
                        public void onError(String message) {
                            System.out.println("Erro ao buscar deputados: " + message);
                        }
                    });
                } else {
                    buscarDeputados();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        deputadoController.getTodosDeputados(new DeputadoController.DeputadosListener<Deputado>() {
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
                // Trate o erro aqui
            }
        });

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
                    tvNoDeputados.setVisibility(deputados.isEmpty() ? View.VISIBLE : View.GONE);
                });
            }

            @Override
            public void onError(String message) {
                System.out.println("Erro ao buscar deputados no ListaDeputadosActivity: " + message);
            }
        });
    }

    private void buscarDeputadosPorNome(String searchTerm) {
        DeputadoController deputadoController = new DeputadoController();
        deputadoController.buscarDeputadosPorNome(searchTerm, new DeputadoController.DeputadosListener<Deputado>() {
            @Override
            public void onDeputadosReceived(List<Deputado> deputados) {
                runOnUiThread(() -> {
                    adapter.filterList(deputados);
                    tvNoDeputados.setVisibility(deputados.isEmpty() ? View.VISIBLE : View.GONE);
                });
            }

            @Override
            public void onError(String message) {
                System.out.println("Erro ao buscar deputados por nome no ListaDeputadosActivity: " + message);
            }
        });
    }

    @Override
    public void onItemClick(Deputado deputado) {
        Intent intent = new Intent(ListaDeputadosActivity.this, DetalhesFinanceirosDeputadoActivity.class);
        intent.putExtra("ID_DEPUTADO", deputado.getId());
        intent.putExtra("NOME_DEPUTADO", deputado.getNome());
        startActivity(intent);
    }
}

