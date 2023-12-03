package com.patademacaco.controle;

import com.patademacaco.enumeracao.Status;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import java.util.ArrayList;
import java.util.Date;

public interface IDenunciaControle {
    public boolean ValidarData(String data) throws Exception;
    public String Cadastrar(Denuncia denuncia)throws Exception;
    public Denuncia Buscar(String protocolo) throws Exception;
    public void Alterar(Denuncia denuncia)throws Exception;
    public ArrayList<Denuncia> Listar()throws Exception;
    public ArrayList<Denuncia> listaFiltrada(int idMunicipio, String cpfDenunciante, int idCategoria, Date dataOcorrido, Date dataDenuncia, Status status) throws Exception;
    public ArrayList<Municipio> ListarMunicipio() throws Exception;
}
