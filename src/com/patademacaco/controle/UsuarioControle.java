package com.patademacaco.controle;

import java.util.ArrayList;
import java.util.Iterator;
import com.patademacaco.modelo.Usuario;
import com.patademacaco.persistencia.IUsuarioDAO;
import com.patademacaco.persistencia.UsuarioDAO;

// @author Mariana

public class UsuarioControle implements IUsuarioControle {
    
    IUsuarioDAO usuarioPersistencia = null;
    
    public UsuarioControle() throws Exception {
        this.usuarioPersistencia = new UsuarioDAO();
    }
    
    private boolean verificaCadastroExistente(String cpf) throws Exception {
        try{
            ArrayList<Usuario> listagem = usuarioPersistencia.listar();
            Iterator<Usuario> lista = listagem.iterator();
            while(lista.hasNext()) {
                Usuario aux = lista.next();
                if(aux.getCpf().equalsIgnoreCase(cpf)) return true;
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    private boolean validaCpf(String cpf) {
        if (cpf.length() == 14) {
            //Cálculo para conferir o primeiro dígito
            int somaPrimeiroDigito = (Integer.parseInt(cpf.charAt(0)+"") * 10)+ (Integer.parseInt(cpf.charAt(1)+"") * 9) 
                    + (Integer.parseInt(cpf.charAt(2)+"") * 8) + (Integer.parseInt(cpf.charAt(4)+"") * 7)
                    + (Integer.parseInt(cpf.charAt(5)+"") * 6) + (Integer.parseInt(cpf.charAt(6)+"") * 5)
                    + (Integer.parseInt(cpf.charAt(8)+"") * 4) + (Integer.parseInt(cpf.charAt(9)+"") * 3)
                    + (Integer.parseInt(cpf.charAt(10)+"") * 2);
            
            int calculoPrimeiroDigito = (11 - (somaPrimeiroDigito % 11));
            if(calculoPrimeiroDigito > 9){
                calculoPrimeiroDigito = 0;
            }
            //Cálculo para conferir o segundo dígito
            int somaSegundoDigito = (Integer.parseInt(cpf.charAt(0)+"") * 11)+ (Integer.parseInt(cpf.charAt(1)+"") * 10) 
                    + (Integer.parseInt(cpf.charAt(2)+"") * 9) + (Integer.parseInt(cpf.charAt(4)+"") * 8)
                    + (Integer.parseInt(cpf.charAt(5)+"") * 7) + (Integer.parseInt(cpf.charAt(6)+"") * 6)
                    + (Integer.parseInt(cpf.charAt(8)+"") * 5) + (Integer.parseInt(cpf.charAt(9)+"") * 4)
                    + (Integer.parseInt(cpf.charAt(10)+"") * 3) + ((calculoPrimeiroDigito) * 2);
            
            int calculoSegundoDigito = (11 - (somaSegundoDigito % 11));
            if(calculoSegundoDigito > 9){
                calculoSegundoDigito = 0;
            }
            //Verificação dos dois últimos dígitos do cpf enviado
            if ((calculoPrimeiroDigito != Integer.parseInt(cpf.charAt(12)+"")) || (calculoSegundoDigito != Integer.parseInt(cpf.charAt(13)+""))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean validaSenha(String senha_BD, String senha_Login) throws Exception {
        try {
            if (senha_BD.equals(senha_Login)) return true;
            return false;
        } catch (Exception erro) {
            throw new Exception("Cpf ou Senha incorreto(s)");
        }
    }
    
    public static boolean validaTipoUsuario(String tipo_BD, String tipo_Login) throws Exception {
        try {
            if (tipo_BD.equals(tipo_Login)) return true;
            return false;
        } catch (Exception erro) {
            throw new Exception("Cpf ou Senha incorreto(s)");
        }
    }

    @Override
    public void cadastrar(Usuario objeto) throws Exception {
        if (objeto.getCpf().equalsIgnoreCase("") || objeto.getCpf().equalsIgnoreCase(" ")) {
            throw new Exception("O Cpf deve ser informado.");
        }
        if (validaCpf(objeto.getCpf())) {
            throw new Exception("Cpf inválido. Digite um Cpf válido.");
        }
        if (verificaCadastroExistente(objeto.getCpf())) {
            throw new Exception("Usuário já cadastrado.");
        }
        if (objeto.getNome().equalsIgnoreCase("")) {
            throw new Exception("O Nome deve ser informado.");
        }
        if (!objeto.getNome().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ]*$")) {
            throw new Exception("O Nome deve conter apenas letras.");
        }
        if (objeto.getEmail().equalsIgnoreCase("")) {
            throw new Exception("O Email deve ser informado.");
        }
        if (objeto.getTelefone().equalsIgnoreCase("")) {
            throw new Exception("O Telefone deve ser informado.");
        }
        if (objeto.getTipo() == null) {
            throw new Exception("Selecione uma das opções como usuário (DENUNCIANTE / ANALISTA).");
        }
        usuarioPersistencia.cadastrar(objeto);
    }

    @Override
    public void alterar(Usuario objeto) throws Exception {
        if (objeto.getNome().equalsIgnoreCase("")) {
            throw new Exception("O Nome deve ser informado.");
        }
        if (!objeto.getNome().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ]*$")) {
            throw new Exception("O Nome deve conter apenas letras.");
        }
        if (objeto.getEmail().equalsIgnoreCase("")) {
            throw new Exception("O Email deve ser informado.");
        }
        if (objeto.getTelefone().equalsIgnoreCase("")) {
            throw new Exception("O Telefone deve ser informado.");
        }
        usuarioPersistencia.alterar(objeto);
    }

    @Override
    public Usuario buscar(String cpf) throws Exception {
        return usuarioPersistencia.buscar(cpf);
    }
    
}
