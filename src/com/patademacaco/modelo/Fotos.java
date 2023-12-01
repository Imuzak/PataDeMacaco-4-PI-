package com.patademacaco.modelo;

import java.util.ArrayList;

public class Fotos {
    private int id = 0;
    private ArrayList<String> urls= null;
    
    public Fotos(){
        
    }
    
    public Fotos(ArrayList<String> urls){
        this.urls = urls;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addUrl(String url){
        urls.add(url);
    }
    
    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrl1(ArrayList<String> urls) {
        this.urls = urls;
    }    
}
