package com.patademacaco.modelo;

public class Categoria {
    private int id = 0;
    private String tipoAmbiental = "";
    
    public Categoria(){
    }
    
    public Categoria(int id,  String tipoAmbiental){
        this.id = id;
        this.tipoAmbiental = tipoAmbiental;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoAmbiental() {
        return tipoAmbiental;
    }

    public void setTipoAmbiental(String tipoAmbiental) {
        this.tipoAmbiental = tipoAmbiental;
    }
    
}
