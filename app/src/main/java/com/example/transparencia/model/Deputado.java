package com.example.transparencia.model;

import java.util.List;

public class Deputado {
    private int id;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String uriPartido;
    private String siglaUf;
    private int idLegislatura;
    private String urlFoto;
    private String email;
    private List<Despesa> despesas;


    public int getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getNome() {
        return nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public int getIdLegislatura() {
        return idLegislatura;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public void setIdLegislatura(int idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
