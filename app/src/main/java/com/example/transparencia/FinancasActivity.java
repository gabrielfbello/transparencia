package com.example.transparencia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transparencia.adapter.LancamentosAdapter;
import com.example.transparencia.model.Lancamento;

import java.util.ArrayList;
import java.util.List;

public class FinancasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLancamentos;
    private LancamentosAdapter adapter;
    private TextView textViewReceita, textViewDespesa, textViewLiquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financas);

        recyclerViewLancamentos = findViewById(R.id.recyclerViewLancamentos);
        textViewReceita = findViewById(R.id.textViewReceita);
        textViewDespesa = findViewById(R.id.textViewDespesa);
        textViewLiquido = findViewById(R.id.textViewLiquido);

        adapter = new LancamentosAdapter(this, getLancamentos());
        recyclerViewLancamentos.setAdapter(adapter);

        recyclerViewLancamentos.setLayoutManager(new LinearLayoutManager(this));

        textViewReceita.setText("Receita R$" + calcularReceita());
        textViewDespesa.setText("Despesa R$" + calcularDespesa());
        textViewLiquido.setText("Líquido R$" + calcularLiquido());
    }

    private List<Lancamento> getLancamentos() {
        // TODO: Implementar a busca de lançamentos
        return new ArrayList<>();
    }

    private double calcularReceita() {
        // TODO: Implementar o cálculo de receita
        return 0.0;
    }

    private double calcularDespesa() {
        // TODO: Implementar o cálculo de despesa
        return 0.0;
    }

    private double calcularLiquido() {
        // TODO: Implementar o cálculo de líquido
        return calcularReceita() - calcularDespesa();
    }
}
