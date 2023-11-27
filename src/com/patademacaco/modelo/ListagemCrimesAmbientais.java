/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patademacaco.modelo;

/**
 *
 * @author drpvr
 */
public class ListagemCrimesAmbientais {

    int IdCrimesAmbientais = 0;
    private String Categoria;
    private String SubCategoria;
    private String DescricaoCompletaCrimesAmbientais;

    public ListagemCrimesAmbientais(int IdCrimesAmbientais, String Categoria, String SubCategoria, String DescricaoCompletaCrimesAmbientais) {
        this.IdCrimesAmbientais = IdCrimesAmbientais;
        this.Categoria = Categoria;
        this.SubCategoria = SubCategoria;
        this.DescricaoCompletaCrimesAmbientais = DescricaoCompletaCrimesAmbientais;
    }
    
    public ListagemCrimesAmbientais(){
        
    }

    public int getIdCrimesAmbientais() {
        return IdCrimesAmbientais;
    }

    public void setIdCrimesAmbientais(int IdCrimesAmbientais) {
        this.IdCrimesAmbientais = IdCrimesAmbientais;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getSubCategoria() {
        return SubCategoria;
    }

    public void setSubCategoria(String SubCategoria) {
        this.SubCategoria = SubCategoria;
    }

    public String getDescricaoCompletaCrimesAmbientais() {
        return DescricaoCompletaCrimesAmbientais;
    }

    public void setDescricaoCompletaCrimesAmbientais(String DescricaoCompletaCrimesAmbientais) {
        this.DescricaoCompletaCrimesAmbientais = DescricaoCompletaCrimesAmbientais;
    }

    @Override
    public String toString() {
        return "TipoCrimesAmbientais{" + "IdCrimesAmbientais=" + IdCrimesAmbientais + ", Categoria=" + Categoria + ", SubCategoria=" + SubCategoria + ", DescricaoCompletaCrimesAmbientais=" + DescricaoCompletaCrimesAmbientais + '}';
    }
    
    

}
