package com.patademacaco.controle;

import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.SubCategoria;
import java.util.ArrayList;

public interface ICategoriaControle {
    public void Cadastrar(Categoria categoria)throws Exception;
    public void Alterar(Categoria categoria)throws Exception;
    public ArrayList<Categoria> ListarCategorias()throws Exception;
    public ArrayList<SubCategoria> ListarSubCategorias() throws Exception;
}
