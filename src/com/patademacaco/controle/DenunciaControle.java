package com.patademacaco.controle;

import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import com.patademacaco.persistencia.DenunciaDao;
import com.patademacaco.persistencia.IDenunciaDao;
import java.util.ArrayList;

public class DenunciaControle implements IDenunciaControle{
    
    IDenunciaDao denunciaDao = null;
    
    public DenunciaControle()throws Exception{
        denunciaDao = new DenunciaDao();
    }

    @Override
    public String Cadastrar(Denuncia denuncia) throws Exception {
        return denunciaDao.Cadastrar(denuncia);
    }

    @Override
    public ArrayList<Denuncia> Buscar(Denuncia denuncia) throws Exception {
        return denunciaDao.Buscar(denuncia);
    }

    @Override
    public void Alterar(Denuncia denuncia) throws Exception {
        denunciaDao.Alterar(denuncia);
    }

    @Override
    public ArrayList<Denuncia> Listar() throws Exception {
        return denunciaDao.Listar();
    }

    @Override
    public ArrayList<Municipio> ListarMunicipio() throws Exception {
        return denunciaDao.ListarMunicipio();
    }
    
}
