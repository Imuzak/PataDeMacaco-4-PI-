package com.patademacaco.modelo;

import com.patademacaco.enumeracao.Status;
import java.util.Date;

public class Denuncia {
    private String protocolo = "";
    private String descricao = "";
    private Categoria categoria = null;
    private Fotos fotos = new Fotos();
    private Date data = null;
    private Date dataDenuncia = null;
    private String autorCrime = "";
    private String parecer = "";
    private Usuario denunciante = null;
    private Usuario analista = null;
    private Endereco endereco = null;
    private Status status = null;
    
    public Denuncia(){
    }
    
    public Denuncia(String protocolo, String descricao, Categoria categoria, Fotos fotos, Date data, Date dataDenuncia, String autorCrime, String parecer, Usuario denunciante, Usuario analista, Endereco endereco, Status status){
        this.protocolo = protocolo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fotos = fotos;
        this.data = data;
        this.dataDenuncia = dataDenuncia;
        this.autorCrime = autorCrime;
        this.parecer = parecer;
        this.denunciante = denunciante;
        this.analista = analista;
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

    public Fotos getFotos() {
        return fotos;
    }

    public void setFotos(Fotos fotos) {
        this.fotos = fotos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Date dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
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

    public Usuario getAnalista() {
        return analista;
    }

    public void setAnalista(Usuario analista) {
        this.analista = analista;
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
