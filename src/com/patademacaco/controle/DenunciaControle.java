package com.patademacaco.controle;

import com.patademacaco.modelo.Denuncia;
import com.patademacaco.persistencia.DenunciaDao;
import com.patademacaco.persistencia.IDenunciaDao;
import java.util.ArrayList;

public class DenunciaControle implements IDenunciaControle{
    
    IDenunciaDao denunciaDao = null;
    
    public DenunciaControle(){
        denunciaDao = new DenunciaDao();
    }

    @Override
    public String Cadastrar(Denuncia denuncia) {
        return denunciaDao.Cadastrar(denuncia);
    }

    @Override
    public Denuncia Buscar(String protocolo) {
        return denunciaDao.Buscar(protocolo);
    }

    @Override
    public void Alterar(Denuncia denuncia) {
        denunciaDao.Alterar(denuncia);
    }

    @Override
    public ArrayList<Denuncia> Listar() {
        return denunciaDao.Listar();
    }
    
}
