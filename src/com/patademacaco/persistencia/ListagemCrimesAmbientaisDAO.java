/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patademacaco.persistencia;

import com.patademacaco.ferramentas.ConexaoBD;
import com.patademacaco.modelo.ListagemCrimesAmbientais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author drpvr
 */
public class ListagemCrimesAmbientaisDAO implements IListagemCrimesAmbientaisDAO {

    private Connection conexao = null;

    public ListagemCrimesAmbientaisDAO() throws Exception {

        conexao = (Connection) ConexaoBD.getConexao();

    }

    @Override
    public void incluir(ListagemCrimesAmbientais objeto) throws Exception {
        try {
            String sql = "INSERT INTO crimesambientais (categoria, subcategoria, descricaocompletacrimesambientais) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getCategoria());
            preparedStatement.setString(2, objeto.getSubCategoria());
            preparedStatement.setString(3, objeto.getDescricaoCompletaCrimesAmbientais());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(ListagemCrimesAmbientais objeto) throws Exception {
       try {
           
            String sql = "UPDATE crimesambientais SET categoria=?, subcategoria=?,descricaocompletacrimesambientais=?  WHERE idservico=" + objeto.getIdCrimesAmbientais() + ";";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
           preparedStatement.setString(1, objeto.getCategoria());
            preparedStatement.setString(2, objeto.getSubCategoria());
            preparedStatement.setString(3, objeto.getDescricaoCompletaCrimesAmbientais());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }    
    }

    @Override
    public void deletar(ListagemCrimesAmbientais objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ListagemCrimesAmbientais> listagem() throws Exception {
        ArrayList<ListagemCrimesAmbientais> listaDosCrimesAmbientais = new ArrayList<ListagemCrimesAmbientais>();
        String sql = "SELECT * FROM servico";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ListagemCrimesAmbientais listagem = new ListagemCrimesAmbientais();
                listagem.setIdCrimesAmbientais(rs.getInt("iddrimesambientais"));
                listagem.setCategoria(rs.getString("categoria"));
                listagem.setSubCategoria(rs.getString("subcategoria"));
                listagem.setDescricaoCompletaCrimesAmbientais("descricaocompletacrimesambientais");
                
                
                listaDosCrimesAmbientais.add(listagem);
            }
            
        } catch (SQLException e) {
              e.printStackTrace();
          }
          return listaDosCrimesAmbientais;
    }

}
