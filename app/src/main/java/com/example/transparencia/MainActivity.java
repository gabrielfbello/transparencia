package com.example.transparencia;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transparencia.api.ApiClient;
import com.example.transparencia.api.ApiInterface;
import com.example.transparencia.api.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testApiCall();
    }

    private void testApiCall() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.getDespesas(2023); // Exemplo: ano 2023

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.i("API_Test", "Resposta recebida: " + response.body().toString());
                    System.out.println("Resposta recebida: " + response.body().toString());
                } else {
                    System.out.println("Erro na resposta: " + response.errorBody());
                    Log.e("API_Test", "Erro na resposta: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("API_Test", "Falha na chamada da API", t);
            }
        });
    }
}
