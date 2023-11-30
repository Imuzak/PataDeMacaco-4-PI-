package com.patademacaco.persistencia;

import java.util.ArrayList;
import com.patademacaco.modelo.Usuario;

// @author Mariana

public interface IUsuarioDAO {
    
    void cadastrar(Usuario objeto) throws Exception;
    void alterar(Usuario objeto) throws Exception;
    Usuario buscar(String cpf) throws Exception;
    ArrayList listar() throws Exception;
    
}
