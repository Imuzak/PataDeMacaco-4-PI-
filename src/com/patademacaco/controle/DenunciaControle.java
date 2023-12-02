package com.patademacaco.controle;

import com.patademacaco.enumeracao.Status;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import com.patademacaco.persistencia.DenunciaDao;
import com.patademacaco.persistencia.IDenunciaDao;
import java.util.ArrayList;
import java.util.Date;

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
    public Denuncia Buscar(String protocolo) throws Exception {
        return denunciaDao.Buscar(protocolo);
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
    public ArrayList<Denuncia> listaFiltrada(int idMunicipio, String cpfDenunciante, int idCategoria, Date dataOcorrido, Date dataDenuncia, Status status) throws Exception {
        return denunciaDao.listaFiltrada(idMunicipio, cpfDenunciante, idCategoria, dataOcorrido, dataDenuncia, status);
    }

    @Override
    public ArrayList<Municipio> ListarMunicipio() throws Exception {
        return denunciaDao.ListarMunicipio();
    }
    
}
