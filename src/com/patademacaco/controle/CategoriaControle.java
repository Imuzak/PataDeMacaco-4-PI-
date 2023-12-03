package com.patademacaco.controle;

import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.SubCategoria;
import com.patademacaco.persistencia.CategoriaDao;
import com.patademacaco.persistencia.ICategoriaDao;
import java.util.ArrayList;

public class CategoriaControle implements ICategoriaControle{
    
    ICategoriaDao categoriaDao = null;
    
    public CategoriaControle() throws Exception{
        categoriaDao = new CategoriaDao();
    }
    
    @Override
    public void Cadastrar(SubCategoria objeto) throws Exception {
        if(objeto.getCategoria().getId() == 0){
            throw new Exception("Selecione uma Categoria de crime ambiental valida!");
        }
        if(objeto.getSubTipoResumo().isBlank()){
            throw new Exception("Preencha o campo com um breve resumo da subcategoria");
        }
        if(objeto.getSubTipo().isBlank()){
            throw new Exception("Preencha o campo com a descrição detalhada da subcategoria");
        }
        categoriaDao.Cadastrar(objeto);
    }

    @Override
    public void Alterar(SubCategoria objeto) throws Exception {
        categoriaDao.Alterar(objeto);
    }

    @Override
    public ArrayList<Categoria> ListarCategorias() throws Exception {
        return categoriaDao.ListarCategorias();
    }

    @Override
    public ArrayList<SubCategoria> ListarSubCategorias(int idCategoria) throws Exception {
        return categoriaDao.ListarSubCategorias(idCategoria);
    }
    
}
