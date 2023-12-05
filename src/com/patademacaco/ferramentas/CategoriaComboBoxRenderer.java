package com.patademacaco.ferramentas;

import com.patademacaco.modelo.Categoria;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class CategoriaComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Categoria) {
                //Armazena o objetoMarca completo
                Categoria objetoCategoria = (Categoria) value;
                //Apresenta apenas a descricao
                value = objetoCategoria.getTipoAmbiental().toUpperCase();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    
}
