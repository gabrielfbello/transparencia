package com.example.transparencia.api;

import java.util.List;

public class ApiResponse<T> {
    private List<T> dados;

    public List<T> getDados() {
        return dados;
    }

    public void setDados(List<T> dados) {
        this.dados = dados;
    }
}
