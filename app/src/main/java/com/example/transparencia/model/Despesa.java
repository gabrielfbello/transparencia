package com.example.transparencia.model;

import java.util.Date;

public class Despesa {
    private int ano;
    private int mes;
    private String tipoDespesa;
    private long codDocumento;
    private String tipoDocumento;
    private int codTipoDocumento;
    private Date dataDocumento;
    private String numDocumento;
    private double valorDocumento;
    private String urlDocumento;
    private String nomeFornecedor;
    private String cnpjCpfFornecedor;
    private double valorLiquido;
    private double valorGlosa;
    private String numRessarcimento;
    private long codLote;
    private int parcela;

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public long getCodDocumento() {
        return codDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public int getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public Date getDataDocumento() {
        return dataDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public double getValorDocumento() {
        return valorDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getCnpjCpfFornecedor() {
        return cnpjCpfFornecedor;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public double getValorGlosa() {
        return valorGlosa;
    }

    public String getNumRessarcimento() {
        return numRessarcimento;
    }

    public long getCodLote() {
        return codLote;
    }

    public int getParcela() {
        return parcela;
    }
}
