package com.patademacaco.persistencia;

import com.patademacaco.ferramentas.ConexaoBD;
import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.SubCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaDao implements ICategoriaDao {
    //ATRIBUTOS DA CLASSE CONECTADA
    private Connection conexao = null;

    //METODOS 
    public CategoriaDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }
    
    @Override
    public void Cadastrar(SubCategoria objeto)throws Exception{
        try{
            String sql = "INSERT INTO subcategoria (subtipo_resumo, subtipo, id_categoria) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getSubTipoResumo());
            preparedStatement.setString(2, objeto.getSubTipo());
            preparedStatement.setInt(3, objeto.getCategoria().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }
    
    @Override
    public void Alterar(SubCategoria objeto)throws Exception{
        try{
            String sql = "UPDATE subcatoria SET subtipo_resumo = ?, subtipo = ? WHERE "+objeto.getIdSubcategoria()+ ";";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getSubTipoResumo());
            preparedStatement.setString(2, objeto.getSubTipo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        } 
    }
    
    @Override
    public ArrayList<Categoria> ListarCategorias()throws Exception{
        ArrayList<Categoria> listaDeCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria ";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()) {
              Categoria categoria = new Categoria();
              categoria.setId(rs.getInt("id_categoria"));
              categoria.setTipoAmbiental(rs.getString("tipo"));
              listaDeCategorias.add(categoria);
            }
          return listaDeCategorias;
        }catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }
    
    @Override
    public ArrayList<SubCategoria> ListarSubCategorias(int idCategoria) throws Exception{
        ArrayList<SubCategoria> listaDeSubCategorias = new ArrayList<>();
        String sql = "SELECT * FROM subcategoria INNER JOIN categoria ON subcategoria.id_categoria = categoria.id_categoria WHERE subcategoria.id_categoria = "+idCategoria+";";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()) {
              SubCategoria subCategoria = new SubCategoria();
              subCategoria.setIdSubcategoria(rs.getInt("id_subcategoria"));
              subCategoria.setSubTipoResumo(rs.getString("subtipo_resumo"));
              subCategoria.setSubTipo(rs.getString("subtipo"));
              
              Categoria categoria = new Categoria();
              categoria.setId(rs.getInt("id_categoria"));
              categoria.setTipoAmbiental(rs.getString("tipo"));
              subCategoria.setCategoria(categoria);
              listaDeSubCategorias.add(subCategoria);
              
            }
          return listaDeSubCategorias;
        }catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }
}
