package com.patademacaco.persistencia;

import com.patademacaco.modelo.Denuncia;
import java.util.ArrayList;

public interface IDenunciaDao {
    public String Cadastrar(Denuncia denuncia);
    public Denuncia Buscar(String protocolo);
    public void Alterar(Denuncia denuncia);
    public ArrayList<Denuncia> Listar();
}
