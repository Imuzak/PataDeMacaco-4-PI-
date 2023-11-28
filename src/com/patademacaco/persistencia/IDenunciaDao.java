package com.patademacaco.persistencia;

import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import java.util.ArrayList;

public interface IDenunciaDao {
    public String Cadastrar(Denuncia denuncia)throws Exception;
    public Denuncia Buscar(String protocolo)throws Exception;
    public void Alterar(Denuncia denuncia)throws Exception;
    public ArrayList<Denuncia> Listar()throws Exception;
    public ArrayList<Municipio> ListarMunicipio() throws Exception;
}
