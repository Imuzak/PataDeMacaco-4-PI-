package com.patademacaco.ferramentas;

import com.patademacaco.modelo.Municipio;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class MunicipioComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Municipio) {
                //Armazena o objetoMarca completo
                Municipio objetoMunicipio = (Municipio) value;
                //Apresenta apenas a descricao
                value = objetoMunicipio.getNome();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
}
