package com.patademacaco.modelo;

public class Endereco {
    private String coordenada = "";
    private String cep = "";
    private String logradouro = "";
    private String bairro = "";
    private Municipio municipio = null;
    private String pontoDeReferencia = "";
    
    public Endereco(){
    }
    
    public Endereco(String coordenada, String cep, String logradouro, String bairro, Municipio municipio, String pontoDeReferencia){
        this.coordenada = coordenada;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.municipio = municipio;
        this.pontoDeReferencia = pontoDeReferencia;        
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }
    
}
