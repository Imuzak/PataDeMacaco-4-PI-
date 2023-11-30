package com.patademacaco.modelo;

public class Categoria {
    private int id = 0;
    private String tipoAmbiental = "";
    private SubCategoria subCategoria = null;
    
    public Categoria(){
    }
    
    public Categoria(int id,  String tipoAmbiental, SubCategoria subCategoria){
        this.id = id;
        this.tipoAmbiental = tipoAmbiental;
        this.subCategoria = subCategoria;
        
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

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }
    
}
