package com.example.transparencia;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesFinanceirosDeputadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputado_financas);

        int idDeputado = getIntent().getIntExtra("ID_DEPUTADO", -1);
        String nomeDeputado = getIntent().getStringExtra("NOME_DEPUTADO");

        TextView tvNomeDeputado = findViewById(R.id.textViewNomeDeputado);
        tvNomeDeputado.setText(nomeDeputado);

        buscarDetalhesFinanceiros(idDeputado);
    }

    private void buscarDetalhesFinanceiros(int idDeputado) {
        // Chamada de API para buscar detalhes financeiros
        // Atualizar a UI com os detalhes obtidos
    }
}

