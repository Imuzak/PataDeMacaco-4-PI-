package com.patademacaco.modelo;

import com.patademacaco.enumeracao.Status;
import java.util.ArrayList;
import java.util.Date;

public class Denuncia {
    private String protocolo = "";
    private String descricao = "";
    private Categoria categoria = null;
    private ArrayList<String> foto = new ArrayList<>();
    private Date data = null;
    private String autorCrime = "";
    private String parecer = "";
    private Usuario denunciante = null;
    private Endereco endereco = null;
    private Status status = null;
    
    public Denuncia(){
    }
    
    public Denuncia(String protocolo, String descricao, Categoria categoria, ArrayList<String> foto, Date data, String autorCrime, String parecer, Usuario denunciante, Endereco endereco, Status status){
        this.protocolo = protocolo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.foto = foto;
        this.data = data;
        this.autorCrime = autorCrime;
        this.parecer = parecer;
        this.denunciante = denunciante;
        this.endereco = endereco;
        this.status = status;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getFoto() {
        return foto;
    }

    public void setFoto(ArrayList<String> foto) {
        this.foto = foto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAutorCrime() {
        return autorCrime;
    }

    public void setAutorCrime(String autorCrime) {
        this.autorCrime = autorCrime;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public Usuario getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Usuario denunciante) {
        this.denunciante = denunciante;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
