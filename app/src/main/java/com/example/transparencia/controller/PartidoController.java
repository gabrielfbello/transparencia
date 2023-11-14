package com.example.transparencia.controller;

import com.example.transparencia.api.ApiClient;
import com.example.transparencia.api.ApiInterface;
import com.example.transparencia.api.ApiResponse;
import com.example.transparencia.model.Partido;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartidoController {

    private ApiInterface apiService;

    public PartidoController() {
        this.apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getPartidos(final PartidosListener listener) {
        Call<ApiResponse<Partido>> call = apiService.getPartidos();

        call.enqueue(new Callback<ApiResponse<Partido>>() {
            @Override
            public void onResponse(Call<ApiResponse<Partido>> call, Response<ApiResponse<Partido>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onPartidosReceived(response.body().getDados());
                } else {
                    // Tratamento de erro
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Partido>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public interface PartidosListener {
        void onPartidosReceived(List<Partido> partidos);
        void onError(String message);
    }
}
