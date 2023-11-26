package com.patademacaco.modelo;

public class Municipio {
    private int id = 0;
    private String nome = "";
    private String uf = "";
    private int codIBGE = 0;

    public Municipio() {
    }
    
    public Municipio(int id, String nome, String uf, int codIBGE){
        this.nome = nome;
        this.codIBGE = codIBGE;
        this.id = id;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(int codIBGE) {
        this.codIBGE = codIBGE;
    }
    
}
