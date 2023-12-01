package com.patademacaco.controle;

import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.SubCategoria;
import java.util.ArrayList;

public interface ICategoriaControle {
    public void Cadastrar(SubCategoria objeto)throws Exception;
    public void Alterar(SubCategoria objeto)throws Exception;
    public ArrayList<Categoria> ListarCategorias()throws Exception;
    public ArrayList<SubCategoria> ListarSubCategorias(int idCategoria) throws Exception;
}
