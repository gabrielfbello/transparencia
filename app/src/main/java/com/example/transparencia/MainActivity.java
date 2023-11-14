package com.example.transparencia;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transparencia.controller.DeputadoController;
import com.example.transparencia.controller.DespesaDeputadoController;
import com.example.transparencia.model.Deputado;
import com.example.transparencia.model.Despesa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Iniciando a aplicação...");

        DeputadoController deputadoController = new DeputadoController();

        System.out.println("Buscando deputados...");
        deputadoController.getDeputados(new DeputadoController.DeputadosListener<Deputado>() {

            @Override
            public void onDeputadosReceived(List<Deputado> deputados) {
                for (Deputado deputado : deputados) {
                    buscarDespesasDeputado(deputado.getId());
                }
            }

            @Override
            public void onError(String message) {
                Log.e("API_Test", "Erro: " + message);
            }
        });
    }

    private void buscarDespesasDeputado(int idDeputado) {
        System.out.println("Buscando despesas do deputado " + idDeputado);

        DespesaDeputadoController despesaController = new DespesaDeputadoController();
        despesaController.getDespesasDeputado(idDeputado, new DespesaDeputadoController.DespesasListener<Despesa>() {
            @Override
            public void onDespesasReceived(List<Despesa> despesas) {
                int count = 0;
                for (Despesa despesa : despesas) {
                    count++;
                    if (count == 3) {
                        break;
                    }
                }
            }

            @Override
            public void onError(String message) {
                Log.e("API_Test", "Erro: " + message);
            }
        });
    }
}
