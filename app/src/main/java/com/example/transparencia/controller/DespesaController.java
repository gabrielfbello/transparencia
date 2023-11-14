package com.example.transparencia.controller;

import com.example.transparencia.api.ApiClient;
import com.example.transparencia.api.ApiInterface;
import com.example.transparencia.model.Despesa;

import java.util.List;

public class DespesaController {

    private ApiInterface apiService;

    public DespesaController() {
        this.apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public interface DespesasListener {
        void onDespesasReceived(List<Despesa> despesas);
        void onError(String message);
    }
}
