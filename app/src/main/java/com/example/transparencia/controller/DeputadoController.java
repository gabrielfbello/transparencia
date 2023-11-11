package com.example.transparencia.controller;

import com.example.transparencia.api.ApiClient;
import com.example.transparencia.api.ApiInterface;
import com.example.transparencia.api.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {

    private ApiInterface apiService;

    public DeputadoController() {
        this.apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getDeputados(int ano, final DeputadosListener listener) {
        Call<ApiResponse> call = apiService.getDespesas(ano); // Modifique de acordo com o endpoint específico

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    listener.onDeputadosReceived(response.body().getDados());
                } else {
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public interface DeputadosListener {
        void onDeputadosReceived(/* Tipo de dados da resposta */List dados);
        void onError(String message);
    }
}
