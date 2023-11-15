package com.example.transparencia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonListarDeputados;
    private Button buttonBuscarDeputados;
    private Button buttonListarPartidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonListarDeputados = findViewById(R.id.buttonListarDeputados);
        buttonBuscarDeputados = findViewById(R.id.buttonBuscarDeputados);
        buttonListarPartidos = findViewById(R.id.buttonListarPartidos);

        buttonListarDeputados.setOnClickListener(view -> {
            System.out.println("Listando deputados ...");

            Intent intent = new Intent(MainActivity.this, ListaDeputadosActivity.class);
            startActivity(intent);
        });


        buttonBuscarDeputados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Implementar lógica para buscar deputados
            }
        });

        buttonListarPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Implementar lógica para listar partidos
            }
        });
    }
}
