/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.patademacaco.persistencia;

import com.patademacaco.modelo.ListagemCrimesAmbientais;
import java.util.ArrayList;

/**
 *
 * @author drpvr
 */
public interface IListagemCrimesAmbientaisDAO {

    void incluir(ListagemCrimesAmbientais objeto) throws Exception;

    void alterar(ListagemCrimesAmbientais objeto) throws Exception;

    void deletar(ListagemCrimesAmbientais objeto) throws Exception;

    ArrayList<ListagemCrimesAmbientais> listagem() throws Exception;

}
