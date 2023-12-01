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
            String sql = "INSERT INTO "+objeto.getCategoria().getTipoAmbiental()+"(resumo, descricao) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getSubTipoResumo());
            preparedStatement.setString(2, objeto.getSubTipo());
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
            String sql = "UPDATE "+objeto.getCategoria().getTipoAmbiental()+" SET resumo = ?, descricao = ? WHERE "+objeto.getIdSubcategoria()+ ";";
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
        String sql = "SELECT * FROM categorias ";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()) {
              Categoria categoria = new Categoria();
              categoria.setId(rs.getInt("idCategoria"));
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
        String sql = "SELECT * FROM subcategorias INNER JOIN categoria ON subcategoria.idCategoria = categoria.idCategoria WHERE idCategoria = "+idCategoria+";";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()) {
              SubCategoria subCategoria = new SubCategoria();
              subCategoria.setIdSubcategoria(rs.getInt("idSubcategoria"));
              subCategoria.setSubTipoResumo(rs.getString("resumo"));
              subCategoria.setSubTipo(rs.getString("subtipo"));
              
              Categoria categoria = new Categoria();
              categoria.setId(rs.getInt("idCategoria"));
              categoria.setTipoAmbiental(rs.getString("tipo"));
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
