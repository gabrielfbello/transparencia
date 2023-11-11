package com.example.transparencia.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("despesas")
    Call<ApiResponse> getDespesas(@Query("ano") int ano);

    @GET("partidos")
    Call<ApiResponse> getPartidos();
}
