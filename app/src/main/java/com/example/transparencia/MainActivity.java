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

        DeputadoController deputadoController = new DeputadoController();
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
                System.out.println("Erro: " + message);
            }
        });
    }

    private void buscarDespesasDeputado(int idDeputado) {
        DespesaDeputadoController despesaController = new DespesaDeputadoController();
        despesaController.getDespesasDeputado(idDeputado, new DespesaDeputadoController.DespesasListener<Despesa>() {
            @Override
            public void onDespesasReceived(List<Despesa> despesas) {
                for (int i = 0; i < despesas.size() && i < 3; i++) {
                    Despesa despesa = despesas.get(i);
                    Log.i("API_Test", "Despesa: " + despesa.getTipoDespesa() + " - " + despesa.getValorLiquido());
                    System.out.println("Despesa: " + despesa.getTipoDespesa() + " - " + despesa.getValorLiquido());
                }
            }

            @Override
            public void onError(String message) {
                Log.e("API_Test", "Erro: " + message);
                System.out.println("Erro: " + message);
            }
        });
    }

}
