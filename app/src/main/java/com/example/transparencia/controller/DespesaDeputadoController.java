package com.example.transparencia.controller;

import android.util.Log;

import com.example.transparencia.api.ApiClient;
import com.example.transparencia.api.ApiInterface;
import com.example.transparencia.api.ApiResponse;
import com.example.transparencia.model.Despesa;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DespesaDeputadoController {

    private ApiInterface apiService;

    public DespesaDeputadoController() {
        this.apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getDespesasDeputado(int idDeputado, final DespesasListener listener) {
        Call<ApiResponse<Despesa>> call = apiService.getDespesasDeputado(idDeputado);

        call.enqueue(new Callback<ApiResponse<Despesa>>() {
            @Override
            public void onResponse(Call<ApiResponse<Despesa>> call, Response<ApiResponse<Despesa>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onDespesasReceived(response.body().getDados());
                } else {
                    String errorBody = "";
                    try {
                        errorBody = response.errorBody() != null ? response.errorBody().string() : "Erro desconhecido";
                    } catch (IOException e) {
                        Log.e("API_Test", "Erro ao ler o corpo da resposta", e);
                    }
                    Log.e("API_Test", "Código de erro: " + response.code() + ", Erro na resposta: " + errorBody);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Despesa>> call, Throwable t) {
                Log.e("API_Test", "Falha na chamada da API", t);
            }
        });
    }

    public interface DespesasListener<T> {
        void onDespesasReceived(List<T> despesas);
        void onError(String message);
    }
}
