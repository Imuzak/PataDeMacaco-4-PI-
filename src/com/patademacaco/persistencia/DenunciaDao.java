package com.patademacaco.persistencia;

import com.patademacaco.ferramentas.ConexaoBD;
import com.patademacaco.modelo.Denuncia;
import java.sql.Connection;
import java.util.ArrayList;

public class DenunciaDao implements IDenunciaDao{
    
    //ATRIBUTOS DA CLASSE CONECTADA
    private Connection conexao = null;

    //METODOS 
    public DenunciaDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public String Cadastrar(Denuncia denuncia) {
        return;
    }

    @Override
    public Denuncia Buscar(String protocolo) {
        return;
    }

    @Override
    public void Alterar(Denuncia denuncia) {
        
    }

    @Override
    public ArrayList<Denuncia> Listar() {
        return;
    }
    
}
