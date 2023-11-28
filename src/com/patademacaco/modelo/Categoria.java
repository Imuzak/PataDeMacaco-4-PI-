package com.patademacaco.modelo;

import com.patademacaco.enumeracao.TipoAmbiental;

public class Categoria {
    private int id = 0;
    private TipoAmbiental tipoAmbiental = null;
    private String subTipoResumo = "";
    private String subTipo = "";
    
    public Categoria(){
    }
    
    public Categoria(int id, TipoAmbiental tipoAmbiental, String subTipoResumo, String subTipo){
        this.id = id;
        this.tipoAmbiental = tipoAmbiental;
        this.subTipoResumo = subTipoResumo;
        this.subTipo = subTipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoAmbiental getTipoAmbiental() {
        return tipoAmbiental;
    }

    public void setTipoAmbiental(TipoAmbiental tipoAmbiental) {
        this.tipoAmbiental = tipoAmbiental;
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
