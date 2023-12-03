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
        String sql = "SELECT * FROM municipios WHERE uf = 52";
        try{
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_municipio"));
                municipio.setNome(rs.getString("name"));
                municipio.setUf(rs.getString("uf_code"));
                municipio.setCodIBGE(rs.getInt("municipio"));
                listaMunicipios.add(municipio);
            }
            return listaMunicipios;
        }catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }
    
    @Override
    public String Cadastrar(Denuncia objeto) throws Exception {
        
        try {
            String sqlFotos = "INSERT INTO fotos (url1, url2, url3, url4) Values (?, ?, ?, ?) RETURNING id_fotos";
            String sql = "INSERT INTO denuncia(cpf_denunciante, id_municipio, cep, logradouro, bairro, ponto_referencia, coordenadas, descricao, id_subcategoria, data_ocorrido, data_denuncia, autor_crime, parecer, status, id_fotos)";
            sql+= " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_denuncia";
            PreparedStatement preparedStatement = conexao.prepareStatement(sqlFotos);
            for (int i = 0; i < 4; i++) {
                if (i < objeto.getFotos().getUrls().size()) {
                    preparedStatement.setString(i + 1, objeto.getFotos().getUrls().get(i));
                } else {
                    preparedStatement.setNull(i + 1, java.sql.Types.VARCHAR); // Se a URL não estiver presente, insere null
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            int idFotos = 0;
            if(rs.next()){
                idFotos = rs.getInt("id_fotos");
            }
            
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getDenunciante().getCpf());
            preparedStatement.setInt(2, objeto.getEndereco().getMunicipio().getId());
            preparedStatement.setString(3, objeto.getEndereco().getCep());
            preparedStatement.setString(4, objeto.getEndereco().getLogradouro());
            preparedStatement.setString(5, objeto.getEndereco().getBairro());
            preparedStatement.setString(6, objeto.getEndereco().getPontoDeReferencia());
            preparedStatement.setString(7, objeto.getEndereco().getCoordenada());
            preparedStatement.setString(8, objeto.getDescricao());
            preparedStatement.setInt(9, objeto.getSubCategoria().getIdSubcategoria());
            preparedStatement.setTimestamp(10, new java.sql.Timestamp(objeto.getData().getTime()));
            preparedStatement.setTimestamp(11, new java.sql.Timestamp(objeto.getDataDenuncia().getTime()));
            preparedStatement.setString(12, objeto.getAutorCrime());
            preparedStatement.setString(13, objeto.getParecer());
            preparedStatement.setString(14, objeto.getStatus().toString());
            preparedStatement.setInt(15, idFotos);
            // Executa o update e coleta o ID para gerar protocolo
            rs = preparedStatement.executeQuery();
            int idGerado = 0;
            if(rs.next()){
                idGerado = rs.getInt("id_denuncia");
            }
            SimpleDateFormat formata = new SimpleDateFormat("yyyy");
            String protocolo =  idGerado +"/"+ formata.format(objeto.getData());
            // Atualiza o protocolo na tabela denuncia
            String sqlUpdate = "UPDATE denuncia SET protocolo = ? WHERE id_denuncia = ?";
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
//        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        String sql = "SELECT denuncia.*, municipios.*, subcategoria.*, categoria.*, fotos.*, ";
        sql += "d.nome AS nome_denunciante, d.email AS email_denunciante, d.telefone AS telefone_denunciante, d.tipo AS tipo_denunciante, ";
        sql += "a.nome AS nome_analista, a.email AS email_analista, a.telefone AS telefone_analista, a.tipo AS tipo_analista  ";
        sql += "FROM denuncia "; 
        sql += "LEFT JOIN municipios ON denuncia.id_municipio = municipios.id_municipio ";
        sql += "LEFT JOIN fotos ON denuncia.id_fotos = fotos.id_fotos ";
        sql += "LEFT JOIN usuario AS d ON denuncia.cpf_denunciante = d.cpf ";
        sql += "LEFT JOIN usuario AS a ON denuncia.cpf_analista = a.cpf ";
        sql += "LEFT JOIN subcategoria ON denuncia.id_subcategoria = subcategoria.id_subcategoria ";
        sql += "LEFT JOIN categoria ON subcategoria.id_categoria = categoria.id_categoria ";
        sql += "WHERE protocolo = '"+protocolo+"';";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          Denuncia denuncia =null;
          if(rs.next()) {
            denuncia = new Denuncia();
            denuncia.setProtocolo(rs.getString("protocolo"));
            denuncia.setDescricao(rs.getString("descricao"));
            denuncia.setAutorCrime(rs.getString("autor_crime"));
            denuncia.setParecer(rs.getString("parecer"));
            denuncia.setStatus(Status.valueOf(rs.getString("status")));
            java.sql.Timestamp dataDenuncia = rs.getTimestamp("data_denuncia");
            java.sql.Timestamp dataOcorrido = rs.getTimestamp("data_ocorrido");
            denuncia.setDataDenuncia(new Date(dataDenuncia.getTime()));
            denuncia.setData(new Date(dataOcorrido.getTime()));
//            String data = rs.getString("data_ocorrido") ;
//            Date date = formata.parse(data);
//            denuncia.setData(date);
//            data = rs.getString("data_denuncia") ;
//            date = formata.parse(data);
//            denuncia.setDataDenuncia(date);
            
            Fotos fotos = new Fotos();
            fotos.setId(rs.getInt("id_fotos"));
            fotos.addUrl(rs.getString("url1"));
            if(rs.getString("url2")!= null){
                fotos.addUrl(rs.getString("url2"));
                if(rs.getString("url2")!= null){
                    fotos.addUrl(rs.getString("url3"));
                    if(rs.getString("url2") != null){
                        fotos.addUrl(rs.getString("url4"));
                    }
                }
            }
            denuncia.setFotos(fotos);
            
            Usuario denunciante = new Usuario();
            denunciante.setCpf(rs.getString("cpf_denunciante"));
            denunciante.setNome(rs.getString("nome_denunciante"));
            denunciante.setEmail(rs.getString("email_denunciante"));            
            denunciante.setTelefone(rs.getString("telefone_denunciante"));
            denunciante.setTipo(TipoUsuario.valueOf(rs.getString("tipo_denunciante")));
            denuncia.setDenunciante(denunciante);
            
            if(rs.getString("cpf_analista")!= null){
                System.out.println("analista listado");
                Usuario analista = new Usuario();
                analista.setCpf(rs.getString("cpf_analista"));
                analista.setNome(rs.getString("nome_analista"));
                analista.setEmail(rs.getString("email_analista"));            
                analista.setTelefone(rs.getString("telefone_analista"));
                analista.setTipo(TipoUsuario.valueOf(rs.getString("tipo_analista")));
                denuncia.setAnalista(analista);
            }

            Endereco endereco = new Endereco();
            endereco.setCoordenada(rs.getString("coordenadas"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setPontoDeReferencia(rs.getString("ponto_referencia"));
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getInt("id_municipio"));
            municipio.setNome(rs.getString("name"));
            municipio.setUf(rs.getString("uf_code"));
            municipio.setCodIBGE(rs.getInt("municipio"));
            endereco.setMunicipio(municipio);
            denuncia.setEndereco(endereco);
            
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setIdSubcategoria(rs.getInt("id_subcategoria"));
            subCategoria.setSubTipoResumo(rs.getString("subtipo_resumo"));
            subCategoria.setSubTipo(rs.getString("subtipo"));

            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id_categoria"));
            categoria.setTipoAmbiental(rs.getString("tipo"));
            subCategoria.setCategoria(categoria);
            denuncia.setSubCategoria(subCategoria);
          }
          return denuncia;
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }

    }

    @Override
    public void Alterar(Denuncia denuncia) throws Exception{
        try{
            String sql = "UPDATE denuncia SET  id_subcategoria = ?, cpf_analista = ?, status = ?, parecer = ?  WHERE protocolo = '" + denuncia.getProtocolo() + "';";
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
        String sql = "SELECT denuncia.*, municipios.*, subcategoria.*, categoria.*, fotos.*, ";
        sql += "d.nome AS nome_denunciante, d.email AS email_denunciante, d.telefone AS telefone_denunciante, d.tipo AS tipo_denunciante, ";
        sql += "a.nome AS nome_analista, a.email AS email_analista, a.telefone AS telefone_analista, a.tipo AS tipo_analista  ";
        sql += "FROM denuncia "; 
        sql += "LEFT JOIN municipios ON denuncia.id_municipio = municipios.id_municipio ";
        sql += "LEFT JOIN fotos ON denuncia.id_fotos = fotos.id_fotos ";
        sql += "LEFT JOIN usuario AS d ON denuncia.cpf_denunciante = d.cpf ";
        sql += "LEFT JOIN usuario AS a ON denuncia.cpf_analista = a.cpf ";
        sql += "LEFT JOIN subcategoria ON denuncia.id_subcategoria = subcategoria.id_subcategoria ";
        sql += "LEFT JOIN categoria ON subcategoria.id_categoria = categoria.id_categoria ;";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while(rs.next()) {
            Denuncia denuncia = new Denuncia();
            denuncia.setProtocolo(rs.getString("protocolo"));
            denuncia.setDescricao(rs.getString("descricao"));
            denuncia.setAutorCrime(rs.getString("autor_crime"));
            denuncia.setParecer(rs.getString("parecer"));

            denuncia.setStatus(Status.valueOf(rs.getString("status")));

            java.sql.Timestamp dataDenuncia = rs.getTimestamp("data_denuncia");

            java.sql.Timestamp dataOcorrido = rs.getTimestamp("data_ocorrido");
            denuncia.setDataDenuncia(new Date(dataDenuncia.getTime()));

            denuncia.setData(new Date(dataOcorrido.getTime()));
//            String data = rs.getString("data_ocorrido") ;
//            Date date = formata.parse(data);
//            denuncia.setData(date);
//            data = rs.getString("data_denuncia") ;
//            date = formata.parse(data);
//            denuncia.setDataDenuncia(date);
            Fotos fotos = new Fotos();
            fotos.setId(rs.getInt("id_fotos"));
            fotos.addUrl(rs.getString("url1"));
            if(rs.getString("url2")!= null){
                fotos.addUrl(rs.getString("url2"));
                if(rs.getString("url2")!= null){
                    fotos.addUrl(rs.getString("url3"));
                    if(rs.getString("url2") != null){
                        fotos.addUrl(rs.getString("url4"));
                    }
                }
            }
            denuncia.setFotos(fotos);

            Usuario denunciante = new Usuario();
            denunciante.setCpf(rs.getString("cpf_denunciante"));
            denunciante.setNome(rs.getString("nome_denunciante"));
            denunciante.setEmail(rs.getString("email_denunciante"));            
            denunciante.setTelefone(rs.getString("telefone_denunciante"));
            denunciante.setTipo(TipoUsuario.valueOf(rs.getString("tipo_denunciante")));
            denuncia.setDenunciante(denunciante);
            if(rs.getString("cpf_analista")!= null){

                Usuario analista = new Usuario();
                analista.setCpf(rs.getString("cpf_analista"));
                analista.setNome(rs.getString("nome_analista"));
                analista.setEmail(rs.getString("email_analista"));            
                analista.setTelefone(rs.getString("telefone_analista"));
                analista.setTipo(TipoUsuario.valueOf(rs.getString("tipo_analista")));
                denuncia.setAnalista(analista);
            }

            Endereco endereco = new Endereco();
            endereco.setCoordenada(rs.getString("coordenadas"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setPontoDeReferencia(rs.getString("ponto_referencia"));

            Municipio municipio = new Municipio();
            municipio.setId(rs.getInt("id_municipio"));
            municipio.setNome(rs.getString("name"));
            municipio.setUf(rs.getString("uf_code"));
            municipio.setCodIBGE(rs.getInt("municipio"));
            endereco.setMunicipio(municipio);
            denuncia.setEndereco(endereco);

            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setIdSubcategoria(rs.getInt("id_subcategoria"));
            subCategoria.setSubTipoResumo(rs.getString("subtipo_resumo"));
            subCategoria.setSubTipo(rs.getString("subtipo"));

            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id_categoria"));
            categoria.setTipoAmbiental(rs.getString("tipo"));
            subCategoria.setCategoria(categoria);
            denuncia.setSubCategoria(subCategoria);
            listaDeDenuncias.add(denuncia);
          }
          return listaDeDenuncias;
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }
    
    @Override
    public ArrayList<Denuncia> listaFiltrada(int idMunicipio, String cpfDenunciante, int idCategoria, Date dataOcorrido, Date dataDenuncia, Status status) throws Exception{
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Denuncia> listaFiltrada = new ArrayList<>();
        String sql = "SELECT denuncia.*, municipios.*, subcategoria.*, categoria.*, fotos.*, ";
        sql += "d.nome AS nome_denunciante, d.email AS email_denunciante, d.telefone AS telefone_denunciante, d.tipo AS tipo_denunciante, ";
        sql += "a.nome AS nome_analista, a.email AS email_analista, a.telefone AS telefone_analista, a.tipo AS tipo_analista  ";
        sql += "FROM denuncia "; 
        sql += "LEFT JOIN municipios ON denuncia.id_municipio = municipios.id_municipio ";
        sql += "LEFT JOIN fotos ON denuncia.id_fotos = fotos.id_fotos ";
        sql += "LEFT JOIN usuario AS d ON denuncia.cpf_denunciante = d.cpf ";
        sql += "LEFT JOIN usuario AS a ON denuncia.cpf_analista = a.cpf ";
        sql += "LEFT JOIN subcategoria ON denuncia.id_subcategoria = subcategoria.id_subcategoria ";
        sql += "LEFT JOIN categoria ON subcategoria.id_categoria = categoria.id_categoria ";
        sql += "WHERE 1=1";
        if(idMunicipio > 0) sql +=" AND denuncia.id_municipio = "+idMunicipio;
        if(cpfDenunciante != null) sql +=" AND cpf_denunciante = '" + cpfDenunciante + "'";
        if(idCategoria > 0) sql +=" AND subcategoria.id_categoria = "+idCategoria;
        if(dataOcorrido != null) sql += " AND data_ocorrido = '"+formata.format(dataOcorrido)+"'";
        if(dataDenuncia != null) sql += " AND data_denuncia = '"+formata.format(dataDenuncia)+"'";
        if(status != null) sql += " AND status = '"+status.toString()+"'";
        sql += " ;";
        try {
          Statement statement = conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          
          while(rs.next()) {
            Denuncia denuncia = new Denuncia();
            denuncia.setProtocolo(rs.getString("protocolo"));
            denuncia.setDescricao(rs.getString("descricao"));
            denuncia.setAutorCrime(rs.getString("autor_crime"));
            denuncia.setParecer(rs.getString("parecer"));

            denuncia.setStatus(Status.valueOf(rs.getString("status")));

            java.sql.Timestamp dataD = rs.getTimestamp("data_denuncia");
            java.sql.Timestamp dataO = rs.getTimestamp("data_ocorrido");
            denuncia.setDataDenuncia(new Date(dataD.getTime()));
            denuncia.setData(new Date(dataO.getTime()));
//            String data = rs.getString("data_ocorrido") ;
//            Date date = formata.parse(data);
//            denuncia.setData(date);
//            data = rs.getString("data_denuncia") ;
//            date = formata.parse(data);
//            denuncia.setDataDenuncia(date);
            Fotos fotos = new Fotos();
            fotos.setId(rs.getInt("id_fotos"));
            fotos.addUrl(rs.getString("url1"));
            if(rs.getString("url2")!= null){
                fotos.addUrl(rs.getString("url2"));
                if(rs.getString("url2")!= null){
                    fotos.addUrl(rs.getString("url3"));
                    if(rs.getString("url2") != null){
                        fotos.addUrl(rs.getString("url4"));
                    }
                }
            }
            denuncia.setFotos(fotos);

            Usuario denunciante = new Usuario();
            denunciante.setCpf(rs.getString("cpf_denunciante"));
            denunciante.setNome(rs.getString("nome_denunciante"));
            denunciante.setEmail(rs.getString("email_denunciante"));            
            denunciante.setTelefone(rs.getString("telefone_denunciante"));
            denunciante.setTipo(TipoUsuario.valueOf(rs.getString("tipo_denunciante")));
            denuncia.setDenunciante(denunciante);
            if(rs.getString("cpf_analista")!= null){

                Usuario analista = new Usuario();
                analista.setCpf(rs.getString("cpf_analista"));
                analista.setNome(rs.getString("nome_analista"));
                analista.setEmail(rs.getString("email_analista"));            
                analista.setTelefone(rs.getString("telefone_analista"));
                analista.setTipo(TipoUsuario.valueOf(rs.getString("tipo_analista")));
                denuncia.setAnalista(analista);
            }

            Endereco endereco = new Endereco();
            endereco.setCoordenada(rs.getString("coordenadas"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setPontoDeReferencia(rs.getString("ponto_referencia"));

            Municipio municipio = new Municipio();
            municipio.setId(rs.getInt("id_municipio"));
            municipio.setNome(rs.getString("name"));
            municipio.setUf(rs.getString("uf_code"));
            municipio.setCodIBGE(rs.getInt("municipio"));
            endereco.setMunicipio(municipio);
            denuncia.setEndereco(endereco);

            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setIdSubcategoria(rs.getInt("id_subcategoria"));
            subCategoria.setSubTipoResumo(rs.getString("subtipo_resumo"));
            subCategoria.setSubTipo(rs.getString("subtipo"));

            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id_categoria"));
            categoria.setTipoAmbiental(rs.getString("tipo"));
            subCategoria.setCategoria(categoria);
            denuncia.setSubCategoria(subCategoria);
            
            listaFiltrada.add(denuncia);
              System.out.println(listaFiltrada.toString());
          }
          return listaFiltrada;
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }

    }
    
}
