package com.patademacaco.controle;

import com.patademacaco.modelo.Usuario;

// @author Mariana

public interface IUsuarioControle {
    
    void cadastrar(Usuario objeto) throws Exception;
    void alterar(Usuario objeto) throws Exception;
    Usuario buscar(String cpf) throws Exception;
    
}
