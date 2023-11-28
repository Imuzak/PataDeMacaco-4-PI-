package com.patademacaco.persistencia;

import com.patademacaco.ferramentas.ConexaoBD;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DenunciaDao implements IDenunciaDao{
    
    //ATRIBUTOS DA CLASSE CONECTADA
    private Connection conexao = null;

    //METODOS 
    public DenunciaDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }
    
    @Override
    public ArrayList<Municipio> ListarMunicipio() throws Exception {
        ArrayList<Municipio> listaMunicipios = new ArrayList<>();
        String sql = "SELECT * FROM municipios ";
        try{
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Municipio municipio = new Municipio();
                municipio.setId(Integer.parseInt(rs.getString("idMunicipio")));
                municipio.setNome(rs.getString("nome"));
                municipio.setUf(rs.getString("uf"));
                municipio.setCodIBGE(Integer.parseInt(rs.getString("codigoIBGE")));
                listaMunicipios.add(municipio);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMunicipios;
    }
    
    @Override
    public String Cadastrar(Denuncia objeto) throws Exception {
        
        try {
            String sqlFotos = "INSERT INTO fotos (url1, url2, url3, url4) Values (?, ?, ?, ?) RETURNING idFotos";
            String sql = "INSERT INTO denuncia(cpfDenunciante, idMunicipio, cep, logradouro, bairro, pontoDeReferencia, descricao, categoria, idCategoria, data, autorCrime, parecer, status, idFotos)";
            sql+= " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING idDenuncia";
            PreparedStatement preparedStatement = conexao.prepareStatement(sqlFotos);
            int idFotos = preparedStatement.executeUpdate();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getDenunciante().getCpf());
            preparedStatement.setInt(2, objeto.getEndereco().getMunicipio().getId());
            preparedStatement.setString(3, objeto.getEndereco().getCep());
            preparedStatement.setString(4, objeto.getEndereco().getLogradouro());
            preparedStatement.setString(5, objeto.getEndereco().getBairro());
            preparedStatement.setString(6, objeto.getEndereco().getPontoDeReferencia());
            preparedStatement.setString(7, objeto.getDescricao());
            preparedStatement.setString(8, objeto.getCategoria().getTipoAmbiental().toString());
            preparedStatement.setInt(9, objeto.getCategoria().getId());
            SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            String datainclusao = formata.format(objeto.getData());
            preparedStatement.setString(10, datainclusao);
            preparedStatement.setString(11, objeto.getAutorCrime());
            preparedStatement.setString(12, objeto.getParecer());
            preparedStatement.setString(13, objeto.getStatus().toString());
            preparedStatement.setInt(14, idFotos);
            int idGerado = preparedStatement.executeUpdate();
            formata = new SimpleDateFormat("yyyy");
            String protocolo =  idGerado +"/"+ formata.format(objeto.getData());
            // Atualiza o protocolo na tabela gasto
            String sqlUpdate = "UPDATE denuncia SET protocolo = ? WHERE idDenuncia = ?";
            PreparedStatement updateStatement = conexao.prepareStatement(sqlUpdate);
            updateStatement.setString(1, protocolo);
            updateStatement.setInt(2, idGerado);
            updateStatement.executeUpdate();
            return protocolo;
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public Denuncia Buscar(String protocolo) throws Exception{
        return;
    }

    @Override
    public void Alterar(Denuncia denuncia) throws Exception{
        String sql = "UPDATE denuncia SET  categoria = ?,  idCategoria = ?  WHERE protocolo =" + denuncia.getProtocolo() + ";";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, denuncia.getCategoria().getTipoAmbiental().toString());
        preparedStatement.setInt(2, denuncia.getCategoria().getId());
    }

    @Override
    public ArrayList<Denuncia> Listar() throws Exception{
        return;
    }
    
}
