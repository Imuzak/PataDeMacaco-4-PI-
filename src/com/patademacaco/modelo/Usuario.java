package com.patademacaco.modelo;

// @author Mariana

import com.patademacaco.enumeracao.TipoUsuario;


public class Usuario {
    private String nome = "";
    private String cpf = "";
    private String email = "";
    private String telefone = "";
    private String senha = "";
    private Tipo tipo = null;
    
    public Usuario(){
        
    }
    
    public Usuario(String nome, String cpf, String email, String telefone, String senha, Tipo tipo){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    private String cpf = "";
    private String nome = "";
    private String email = "";
    private String telefone = "";
    private String senha = "";
    private TipoUsuario tipo = null; //Enumeration
    
    public Usuario() {
        
    }
    
    public Usuario(String cpf, String nome, String email, String telefone, String senha, TipoUsuario tipo) {
        
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.tipo = tipo;
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", senha=" + senha + ", tipo=" + tipo + '}';
    }    
    
}
