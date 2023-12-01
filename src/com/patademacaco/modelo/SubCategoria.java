package com.patademacaco.modelo;

public class SubCategoria {
    private int idSubcategoria = 0;
    private String subTipoResumo = "";
    private String subTipo = "";
    private Categoria categoria = null;
    
    public SubCategoria(){
    }
    
    public SubCategoria(int idSubcategoria, String subTipoResumo, String subTipo, Categoria categoria){
        this.idSubcategoria = idSubcategoria;
        this.subTipoResumo = subTipoResumo;
        this.subTipo = subTipo;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }
    public String getSubTipoResumo() {
        return subTipoResumo;
    }

    public void setSubTipoResumo(String subTipoResumo) {
        this.subTipoResumo = subTipoResumo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }
}
