package com.patademacaco.controle;

import com.patademacaco.modelo.Municipio;
import java.util.ArrayList;

public class MunicipioControle implements IMunicipioControle{
    
    IMunicipioDao municipioDao = null;
    
    public MunicipioControle(){
        municipioDao = new MunicipioDao();
    }
    
    @Override
    public ArrayList<Municipio> ListarMunicipio() {
        return municipioDao.ListarMunicipio;
    }
    
}
