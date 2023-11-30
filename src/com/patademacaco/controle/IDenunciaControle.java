package com.patademacaco.controle;

import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import java.util.ArrayList;

public interface IDenunciaControle {
    public String Cadastrar(Denuncia denuncia)throws Exception;
    public ArrayList<Denuncia> Buscar(Denuncia denuncia) throws Exception;
    public void Alterar(Denuncia denuncia)throws Exception;
    public ArrayList<Denuncia> Listar()throws Exception;
    public ArrayList<Municipio> ListarMunicipio() throws Exception;
}
