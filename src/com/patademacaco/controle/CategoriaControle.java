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
    public void Cadastrar(Categoria categoria) throws Exception {
        categoriaDao.Cadastrar(categoria);
    }

    @Override
    public void Alterar(Categoria categoria) throws Exception {
        categoriaDao.Alterar(categoria);
    }

    @Override
    public ArrayList<Categoria> ListarCategorias() throws Exception {
        return categoriaDao.ListarCategorias();
    }

    @Override
    public ArrayList<SubCategoria> ListarSubCategorias() throws Exception {
        return categoriaDao.ListarSubCategorias();
    }
    
}
