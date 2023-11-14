package com.example.transparencia.api;

import com.example.transparencia.model.Deputado;
import com.example.transparencia.model.Despesa;
import com.example.transparencia.model.Partido;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("deputados")
    Call<ApiResponse<Deputado>> getDeputados();

    @GET("partidos")
    Call<ApiResponse<Partido>> getPartidos();

    @GET("deputados/{id}/despesas")
    Call<ApiResponse<Despesa>> getDespesasDeputado(@Path("id") int idDeputado);
}
