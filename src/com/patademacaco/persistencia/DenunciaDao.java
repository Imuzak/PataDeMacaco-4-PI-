package com.patademacaco.persistencia;

import com.patademacaco.enumeracao.Status;
import com.patademacaco.enumeracao.TipoUsuario;
import com.patademacaco.ferramentas.ConexaoBD;
import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Endereco;
import com.patademacaco.modelo.Fotos;
import com.patademacaco.modelo.Municipio;
import com.patademacaco.modelo.SubCategoria;
import com.patademacaco.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
            String sql = "INSERT INTO denuncia(cpfDenunciante, cpfAnalista, idMunicipio, cep, logradouro, bairro, pontoDeReferencia, descricao, idCategoria, idSubcategoria, data, dataDenuncia, autorCrime, parecer, status, idFotos)";
            sql+= " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING idDenuncia";
            PreparedStatement preparedStatement = conexao.prepareStatement(sqlFotos);
            for (int i = 0; i < 4; i++) {
                if (i < objeto.getFotos().getUrls().size()) {
                    preparedStatement.setString(i + 1, objeto.getFotos().getUrls().get(i));
                } else {
                    preparedStatement.setNull(i + 1, java.sql.Types.VARCHAR); // Se a URL não estiver presente, insere null
                }
            }
            int idFotos = preparedStatement.executeUpdate();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getDenunciante().getCpf());
            preparedStatement.setString(2, objeto.getAnalista().getCpf());
            preparedStatement.setInt(3, objeto.getEndereco().getMunicipio().getId());
            preparedStatement.setString(4, objeto.getEndereco().getCep());
            preparedStatement.setString(5, objeto.getEndereco().getLogradouro());
            preparedStatement.setString(6, objeto.getEndereco().getBairro());
            preparedStatement.setString(7, objeto.getEndereco().getPontoDeReferencia());
            preparedStatement.setString(8, objeto.getDescricao());
            preparedStatement.setInt(9, objeto.getSubCategoria().getCategoria().getId());
            preparedStatement.setInt(10, objeto.getSubCategoria().getIdSubcategoria());
            SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            String datainclusao = formata.format(objeto.getData());
            String dataDenuncia = formata.format(objeto.getDataDenuncia());
            preparedStatement.setString(11, datainclusao);
            preparedStatement.setString(12, dataDenuncia);
            preparedStatement.setString(13, objeto.getAutorCrime());
            preparedStatement.setString(14, objeto.getParecer());
            preparedStatement.setString(15, objeto.getStatus().toString());
            preparedStatement.setInt(16, idFotos);
            // Executa o update e coleta o ID para gerar protocolo
            int idGerado = preparedStatement.executeUpdate();
            formata = new SimpleDateFormat("yyyy");
            String protocolo =  idGerado +"/"+ formata.format(objeto.getData());
            // Atualiza o protocolo na tabela denuncia
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
    public ArrayList<Denuncia> Buscar(Denuncia objeto) throws Exception{
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Denuncia> listaFiltrada = new ArrayList<>();
        String sql = "denuncias.*, municipio.*, subcategoria*, categoria*, fotos*, ";
        sql += "d.nome AS nomeDenunciante, d.email AS emailDenunciante, d.telefone AS telefoneDenunciante, d.tipo AS tipoDenunciante, ";
        sql += "a.nome AS nomeAnalista, a.email AS emailAnalista, a.telefone AS telefoneAnalista, a.tipo AS tipoAnalista  ";
        sql += "INNER JOIN municipio ON denuncia.idDenuncia = municipio.idMunicipio ";
        sql += "INNER JOIN fotos ON denuncia.idFotos = fotos.idFotos ";
        sql += "INNER JOIN usuario AS d ON denuncia.cpfDenunciante = denunciante.cpf ";
        sql += "INNER JOIN usuario AS a ON denuncia.cpfAnalista = analista.cpf ";
        sql += "INNER JOIN subcategoria ON denuncia.idSubCategoria = categoria.idSubCategoria ";
        sql += "INNER JOIN categoria ON subcategoria.idCategoria = categoria.idCategoria ";
        sql += "WHERE 1=1";
        if(!objeto.getProtocolo().equalsIgnoreCase("")) {
            sql += " AND protocolo = '"+objeto.getProtocolo()+"'";
        }else{
            if(objeto.getEndereco().getMunicipio().getId() > 0) sql +=" AND idMunicipio = "+objeto.getEndereco().getMunicipio().getId();
            if(objeto.getSubCategoria().getCategoria().getId() > 0) sql +=" AND idCategoria = "+objeto.getSubCategoria().getCategoria().getId();
            if(objeto.getData()!= null) sql += " AND data = '"+formata.format(objeto.getData())+"'";
            if(objeto.getDataDenuncia()!= null) sql += " AND dataDenuncia = '"+formata.format(objeto.getDataDenuncia())+"'";
            if(objeto.getStatus() != null) sql += " AND status = '"+objeto.getStatus().toString()+"'";
        }
        sql += " ;";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          Denuncia denuncia = new Denuncia();
          while (rs.next()) {
            denuncia.setProtocolo(rs.getString("protocolo"));
            denuncia.setDescricao(rs.getString("descricao"));
            denuncia.setAutorCrime(rs.getString("autorCrime"));
            denuncia.setParecer(rs.getString("parecer"));
            denuncia.setStatus(Status.valueOf(rs.getString("status")));
            String data = rs.getString("data") ;
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            denuncia.setData(date);
            data = rs.getString("dataDenuncia") ;
            date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            denuncia.setDataDenuncia(date);
            
            Fotos fotos = new Fotos();
            fotos.setId(rs.getInt("idFotos"));
            fotos.addUrl(rs.getString("url1"));
            if(!rs.getString("url2").equalsIgnoreCase(null)){
                fotos.addUrl(rs.getString("url2"));
                if(!rs.getString("url2").equalsIgnoreCase(null)){
                    fotos.addUrl(rs.getString("url3"));
                    if(!rs.getString("url2").equalsIgnoreCase(null)){
                        fotos.addUrl(rs.getString("url4"));
                    }
                }
            }
            denuncia.setFotos(fotos);
            
            Usuario denunciante = new Usuario();
            denunciante.setCpf(rs.getString("cpfDenunciante"));
            denunciante.setNome(rs.getString("nomeDenunciante"));
            denunciante.setEmail(rs.getString("emailDenunciante"));            
            denunciante.setTelefone(rs.getString("telefoneDenunciante"));
            denunciante.setTipo(TipoUsuario.valueOf(rs.getString("tipoDenunciante")));
            denuncia.setDenunciante(denunciante);
            
            Usuario analista = new Usuario();
            analista.setCpf(rs.getString("cpfAnalista"));
            analista.setNome(rs.getString("nomeAnalista"));
            analista.setEmail(rs.getString("emailAnalista"));            
            analista.setTelefone(rs.getString("telefoneAnalista"));
            analista.setTipo(TipoUsuario.valueOf(rs.getString("tipoAnalista")));
            denuncia.setAnalista(analista);

            Endereco endereco = new Endereco();
            endereco.setCoordenada(rs.getString("coordenada"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setPontoDeReferencia(rs.getString("pontoDeReferencia"));
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getInt("idMunicipio"));
            municipio.setNome(rs.getString("nome"));
            municipio.setUf(rs.getString("uf"));
            municipio.setCodIBGE(rs.getInt("codIbge"));
            endereco.setMunicipio(municipio);
            denuncia.setEndereco(endereco);
            
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setIdSubcategoria(rs.getInt("idSubcategoria"));
            subCategoria.setSubTipoResumo(rs.getString("resumo"));
            subCategoria.setSubTipo(rs.getString("subtipo"));

            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("idCategoria"));
            categoria.setTipoAmbiental(rs.getString("tipo"));
            subCategoria.setCategoria(categoria);
            denuncia.setSubCategoria(subCategoria);
            
            listaFiltrada.add(denuncia);
          }
          return listaFiltrada;
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }

    }

    @Override
    public void Alterar(Denuncia denuncia) throws Exception{
        try{
            String sql = "UPDATE denuncia SET  idSubCategoria = ?, cpfAnalista = ?, status = ?, parecer = ?  WHERE protocolo =" + denuncia.getProtocolo() + ";";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, denuncia.getSubCategoria().getIdSubcategoria());
            preparedStatement.setString(2, denuncia.getAnalista().getCpf());
            preparedStatement.setString(3, denuncia.getStatus().toString());
            preparedStatement.setString(4, denuncia.getParecer());
            preparedStatement.executeUpdate();
        }catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public ArrayList<Denuncia> Listar() throws Exception{
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Denuncia> listaDeDenuncias = new ArrayList<>();
        String sql = "denuncias.*, municipio.*, subcategoria*, categoria*, fotos*, ";
        sql += "d.nome AS nomeDenunciante, d.email AS emailDenunciante, d.telefone AS telefoneDenunciante, d.tipo AS tipoDenunciante, ";
        sql += "a.nome AS nomeAnalista, a.email AS emailAnalista, a.telefone AS telefoneAnalista, a.tipo AS tipoAnalista  ";
        sql += "INNER JOIN municipio ON denuncia.idDenuncia = municipio.idMunicipio ";
        sql += "INNER JOIN fotos ON denuncia.idFotos = fotos.idFotos ";
        sql += "INNER JOIN usuario AS d ON denuncia.cpfDenunciante = denunciante.cpf";
        sql += "INNER JOIN usuario AS a ON denuncia.cpfAnalista = analista.cpf";
        sql += "INNER JOIN subcategoria ON denuncia.idSubCategoria = categoria.idSubCategoria ";
        sql += "INNER JOIN categoria ON subcategoria.idCategoria = categoria.idCategoria ";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()) {
            Denuncia denuncia = new Denuncia();
            denuncia.setProtocolo(rs.getString("protocolo"));
            denuncia.setDescricao(rs.getString("descricao"));
            denuncia.setAutorCrime(rs.getString("autorCrime"));
            denuncia.setParecer(rs.getString("parecer"));
            denuncia.setStatus(Status.valueOf(rs.getString("status")));
            String data = rs.getString("data") ;
            Date date = formata.parse(data);
            denuncia.setData(date);
            data = rs.getString("dataDenuncia") ;
            date = formata.parse(data);
            denuncia.setDataDenuncia(date);
            
            Fotos fotos = new Fotos();
            fotos.setId(rs.getInt("idFotos"));
            fotos.addUrl(rs.getString("url1"));
            if(!rs.getString("url2").equalsIgnoreCase(null)){
                fotos.addUrl(rs.getString("url2"));
                if(!rs.getString("url2").equalsIgnoreCase(null)){
                    fotos.addUrl(rs.getString("url3"));
                    if(!rs.getString("url2").equalsIgnoreCase(null)){
                        fotos.addUrl(rs.getString("url4"));
                    }
                }
            }
            denuncia.setFotos(fotos);
            
            Usuario denunciante = new Usuario();
            denunciante.setCpf(rs.getString("cpfDenunciante"));
            denunciante.setNome(rs.getString("nomeDenunciante"));
            denunciante.setEmail(rs.getString("emailDenunciante"));            
            denunciante.setTelefone(rs.getString("telefoneDenunciante"));
            denunciante.setTipo(TipoUsuario.valueOf(rs.getString("tipoDenunciante")));
            denuncia.setDenunciante(denunciante);
            
            Usuario analista = new Usuario();
            analista.setCpf(rs.getString("cpfAnalista"));
            analista.setNome(rs.getString("nomeAnalista"));
            analista.setEmail(rs.getString("emailAnalista"));            
            analista.setTelefone(rs.getString("telefoneAnalista"));
            analista.setTipo(TipoUsuario.valueOf(rs.getString("tipoAnalista")));
            denuncia.setAnalista(analista);

            Endereco endereco = new Endereco();
            endereco.setCoordenada(rs.getString("coordenada"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setPontoDeReferencia(rs.getString("pontoDeReferencia"));
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getInt("idMunicipio"));
            municipio.setNome(rs.getString("nome"));
            municipio.setUf(rs.getString("uf"));
            municipio.setCodIBGE(rs.getInt("codIbge"));
            endereco.setMunicipio(municipio);
            denuncia.setEndereco(endereco);
            
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setIdSubcategoria(rs.getInt("idSubcategoria"));
            subCategoria.setSubTipoResumo(rs.getString("resumo"));
            subCategoria.setSubTipo(rs.getString("subtipo"));

            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("idCategoria"));
            categoria.setTipoAmbiental(rs.getString("tipo"));
            subCategoria.setCategoria(categoria);
            denuncia.setSubCategoria(subCategoria);
            
            listaDeDenuncias.add(denuncia);
          }
          return listaDeDenuncias;
        }catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        } 
    }
    
}
