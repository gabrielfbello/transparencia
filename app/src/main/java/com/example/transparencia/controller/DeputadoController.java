package com.example.transparencia.controller;

import android.util.Log;

import com.example.transparencia.api.ApiClient;
import com.example.transparencia.api.ApiInterface;
import com.example.transparencia.api.ApiResponse;
import com.example.transparencia.model.Deputado;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {

    private ApiInterface apiService;

    public DeputadoController() {
        this.apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public void buscarDeputados() {
        Call<ApiResponse<Deputado>> call = apiService.getDeputados();
    }
    public void getDeputados(final DeputadosListener<Deputado> listener) {
        Call<ApiResponse<Deputado>> call = apiService.getDeputados();

        System.out.println("Chamando a API: " + call.request().url());

        call.enqueue(new Callback<ApiResponse<Deputado>>() {
            @Override
            public void onResponse(Call<ApiResponse<Deputado>> call, Response<ApiResponse<Deputado>> response) {
                System.out.println("Resposta da API: " + response);

                if (response.isSuccessful()) {
                    ApiResponse<Deputado> apiResponse = response.body();
                    List<Deputado> deputados = apiResponse.getDados();
                    listener.onDeputadosReceived(deputados);
                } else {
                    String errorBody = "";
                    try {
                        errorBody = response.errorBody().string();
                    } catch (IOException e) {
                        Log.e("API_Test", "Erro ao ler o corpo da resposta", e);
                        System.out.println("Erro ao ler o corpo da resposta" + e);
                    }
                    Log.e("API_Test", "Código de erro: " + response.code() + ", Erro na resposta: " + errorBody);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Deputado>> call, Throwable t) {
                Log.e("API_Test", "Falha na chamada da API", t);
            }
        });
    }

    public interface DeputadosListener<T> {
        void onDeputadosReceived(List<T> dados);
        void onError(String message);
    }
}
