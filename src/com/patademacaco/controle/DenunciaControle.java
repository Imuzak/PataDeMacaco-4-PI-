package com.patademacaco.controle;

import com.patademacaco.enumeracao.Status;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import com.patademacaco.persistencia.DenunciaDao;
import com.patademacaco.persistencia.IDenunciaDao;
import java.util.ArrayList;
import java.util.Date;

public class DenunciaControle implements IDenunciaControle{
    
    IDenunciaDao denunciaDao = null;
    
    public DenunciaControle()throws Exception{
        denunciaDao = new DenunciaDao();
    }

    @Override
    public String Cadastrar(Denuncia denuncia) throws Exception {
        if (denuncia.getData().compareTo(denuncia.getDataDenuncia())> 0 ){
            throw new Exception("Data invalida!");
        }
        if (denuncia.getEndereco().getCep().length()<10){
            throw new Exception("CEP invalido!");
        }
        if(denuncia.getEndereco().getLogradouro().isBlank()){
            throw new Exception("Campo Logradouro deve estar preenchido!");
        }
        if(denuncia.getEndereco().getBairro().isBlank()){
            throw new Exception("Campo Bairro deve estar preenchido!");
        }
        if(denuncia.getEndereco().getMunicipio().getId() == 0){
            throw new Exception("Selecione um municipio valido!");
        }
        if(denuncia.getSubCategoria().getCategoria().getId() == 0){
            throw new Exception("Selecione uma Categoria de crime ambiental valida!");
        }
        if(denuncia.getSubCategoria().getIdSubcategoria() == 0){
            throw new Exception("Selecione uma Subcategoria de crime ambiental valida!");
        }
        if(denuncia.getDescricao().isBlank()){
            throw new Exception("Descreva no campo Relato do Ocorrido sobre a ocorrencia.");
        }
        if(denuncia.getFotos().getUrls().isEmpty()){
            throw new Exception("Pelo menos 1(uma) foto deve ser enviada!");
        }
        return denunciaDao.Cadastrar(denuncia);
    }
    
    @Override
    public boolean ValidarData(String data) throws Exception{
        int digitos = data.replaceAll("\\D", "").length();
        if (data.equals("  /  /    ")){
            throw new Exception("Campo de data deve ser preenchido!");
        }
        if(digitos < 8){
            throw new Exception("Data invalida!");
        }
        return true;
    }
    
    @Override
    public Denuncia Buscar(String protocolo) throws Exception {
        Denuncia denuncia = denunciaDao.Buscar(protocolo);
        if(denuncia == null){
            throw new Exception("Protocolo invalido ou não encontrado!");
        }
        return denuncia;
    }

    @Override
    public void Alterar(Denuncia denuncia) throws Exception {
        if(denuncia.getStatus() == Status.CONCLUIDA && denuncia.getParecer().isBlank()){
            throw new Exception("O analista deve preencher o campo de Parecer ao finalizar a ocorrencia.");
        }
        if(denuncia.getEndereco().getMunicipio().getId() == 0){
            throw new Exception("Selecione um municipio valido!");
        }
        if(denuncia.getSubCategoria().getCategoria().getId() == 0){
            throw new Exception("Selecione uma Categoria de crime ambiental valida!");
        }
        if(denuncia.getSubCategoria().getIdSubcategoria() == 0){
            throw new Exception("Selecione uma Subcategoria de crime ambiental valida!");
        }
        denunciaDao.Alterar(denuncia);
    }

    @Override
    public ArrayList<Denuncia> Listar() throws Exception {
        return denunciaDao.Listar();
    }
    
    @Override
    public ArrayList<Denuncia> listaFiltrada(int idMunicipio, String cpfDenunciante, int idCategoria, Date dataOcorrido, Date dataDenuncia, Status status) throws Exception {
        return denunciaDao.listaFiltrada(idMunicipio, cpfDenunciante, idCategoria, dataOcorrido, dataDenuncia, status);
    }

    @Override
    public ArrayList<Municipio> ListarMunicipio() throws Exception {
        return denunciaDao.ListarMunicipio();
    }
    
}
