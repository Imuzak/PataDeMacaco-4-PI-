package com.patademacaco.modelo;

public class SubCategoria {
    private int idSubcategoria = 0;
    private String subTipoResumo = "";
    private String subTipo = "";
    
    public SubCategoria(){
    }
    
    public SubCategoria(int idSubcategoria, String subTipoResumo, String subTipo){
        this.idSubcategoria = idSubcategoria;
        this.subTipoResumo = subTipoResumo;
        this.subTipo = subTipo;
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
