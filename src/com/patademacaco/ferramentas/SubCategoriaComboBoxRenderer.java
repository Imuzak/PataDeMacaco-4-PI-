package com.patademacaco.ferramentas;

import com.patademacaco.modelo.SubCategoria;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class SubCategoriaComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof SubCategoria) {
                //Armazena o objetoMarca completo
                SubCategoria objetoSubCategoria = (SubCategoria) value;
                //Apresenta apenas a descricao
                value = objetoSubCategoria.getSubTipoResumo();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
}
