package com.patademacaco.persistencia;

// @author Mariana

import com.patademacaco.enumeracao.TipoUsuario;
import com.patademacaco.ferramentas.ConexaoBD;
import java.util.ArrayList;
import com.patademacaco.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;

 
public class UsuarioDAO implements IUsuarioDAO {
    
    private Connection conexao = null;
    
    public UsuarioDAO() throws Exception {
        
        conexao = (Connection) ConexaoBD.getConexao();
        
    }

    @Override
    public void cadastrar(Usuario objeto) throws Exception {
        try {
            String sql = "insert into usuario(cpf, nome, email, telefone, senha, tipo) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            // Parameters iniciar os elementos
            preparedStatement.setString(1, objeto.getCpf());
            preparedStatement.setString(2, objeto.getNome());
            preparedStatement.setString(3, objeto.getEmail());
            preparedStatement.setString(4, objeto.getTelefone());
            preparedStatement.setString(5, objeto.getSenha());
            preparedStatement.setString(6, objeto.getTipo().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        } 
    }

    @Override
    public void alterar(Usuario objeto) throws Exception {
        try{
            String sql = "update usuario set nome = ?, email = ?, telefone = ?, senha = ? where cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getNome());
            preparedStatement.setString(2, objeto.getEmail());
            preparedStatement.setString(3, objeto.getTelefone());
            preparedStatement.setString(4, objeto.getSenha());
            preparedStatement.setString(5, objeto.getCpf());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: "+ erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public Usuario buscar(String cpf) throws Exception {
        Usuario usuario = null;
        try{
            String sql = "select * from usuario where cpf = '" + cpf + "'";
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                usuario = new Usuario();
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(TipoUsuario.valueOf(rs.getString("tipo").toUpperCase()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return usuario;
    }

    @Override
    public ArrayList<Usuario> listar() throws Exception {
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        String sql = "select * from usuario";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setCpf(rs.getString("cpf"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipo(TipoUsuario.valueOf(rs.getString("tipo").toUpperCase()));
            listaUsuario.add(usuario);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
        listaUsuario.sort(Comparator.comparing(Usuario::getNome).thenComparing(Usuario::getCpf));
          return listaUsuario;
    }

    @Override
    public void deletar(Usuario objeto) throws Exception {
        try {
            String sql = "delete from usuario where cpf = '" + objeto.getCpf()+ "';";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }
}
