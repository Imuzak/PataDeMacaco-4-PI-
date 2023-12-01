package com.patademacaco.visao;

// @author Mariana

import com.patademacaco.ferramentas.CategoriaComboBoxRenderer;
import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Municipio;
import com.patademacaco.modelo.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


public class TelaDeBusca extends javax.swing.JFrame {

    public TelaDeBusca() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        boxCategoria();
        jTextFieldBuscarProtocolo.setEditable(false);
        jComboBoxMunicipio.setEnabled(false);
        jComboBoxCategoria.setEnabled(false);
        jFormattedTextFieldDataOcorrencia.setEnabled(false);
        jFormattedTextFieldDataCadastro.setEnabled(false);
    }
    
    public TelaDeBusca(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);

        jTextFieldBuscarProtocolo.setEditable(false);
        jComboBoxMunicipio.setEnabled(false);
        jComboBoxCategoria.setEnabled(false);
        jFormattedTextFieldDataOcorrencia.setEnabled(false);
        jFormattedTextFieldDataCadastro.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jSeparatorTitulo = new javax.swing.JSeparator();
        jCheckBoxCategoria = new javax.swing.JCheckBox();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jCheckBoxProtocolo = new javax.swing.JCheckBox();
        jTextFieldBuscarProtocolo = new javax.swing.JTextField();
        jCheckBoxMunicipio = new javax.swing.JCheckBox();
        jComboBoxMunicipio = new javax.swing.JComboBox<>();
        jCheckBoxDataDaOcorrencia = new javax.swing.JCheckBox();
        jCheckBoxDataDoCadastro = new javax.swing.JCheckBox();
        jFormattedTextFieldDataOcorrencia = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataCadastro = new javax.swing.JFormattedTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabelTitulo2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelTitulo2.setText("Buscar por");
        jLabelTitulo2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparatorTitulo.setForeground(new java.awt.Color(51, 153, 0));

        jCheckBoxCategoria.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxCategoria.setText("Categoria");
        jCheckBoxCategoria.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxCategoriaStateChanged(evt);
            }
        });

        jComboBoxCategoria.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jCheckBoxProtocolo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxProtocolo.setText("Protocolo");
        jCheckBoxProtocolo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxProtocoloStateChanged(evt);
            }
        });

        jTextFieldBuscarProtocolo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jCheckBoxMunicipio.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxMunicipio.setText("Município");
        jCheckBoxMunicipio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxMunicipioStateChanged(evt);
            }
        });

        jComboBoxMunicipio.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jCheckBoxDataDaOcorrencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxDataDaOcorrencia.setText("Data da Ocorrência");
        jCheckBoxDataDaOcorrencia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxDataDaOcorrenciaStateChanged(evt);
            }
        });

        jCheckBoxDataDoCadastro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxDataDoCadastro.setText("Data do Cadastro da Denúncia");
        jCheckBoxDataDoCadastro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxDataDoCadastroStateChanged(evt);
            }
        });

        try {
            jFormattedTextFieldDataOcorrencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataOcorrencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        try {
            jFormattedTextFieldDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataCadastro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jButtonBuscar.setBackground(new java.awt.Color(163, 177, 138));
        jButtonBuscar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(163, 177, 138));
        jButtonCancelar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparatorTitulo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxCategoria)
                                    .addComponent(jCheckBoxMunicipio)
                                    .addComponent(jCheckBoxProtocolo)
                                    .addComponent(jCheckBoxDataDaOcorrencia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldBuscarProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxCategoria, 0, 440, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo2)
                            .addComponent(jCheckBoxDataDoCadastro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jFormattedTextFieldDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBuscar)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxProtocolo)
                    .addComponent(jTextFieldBuscarProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxMunicipio)
                    .addComponent(jComboBoxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDataDaOcorrencia)
                    .addComponent(jFormattedTextFieldDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDataDoCadastro)
                    .addComponent(jFormattedTextFieldDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void boxCategoria(ArrayList<Categoria> lista) throws Exception {
        DefaultComboBoxModel<Categoria> defaultComboBox = new DefaultComboBoxModel<>();
        Categoria objeto = new Categoria();
        objeto.setTipoAmbiental("-SELECIONE-");
        defaultComboBox.addElement(objeto);
        for (Categoria objetoCategoria : lista) {
            defaultComboBox.addElement(objetoCategoria);
        }
        jComboBoxCategoria.setRenderer(new CategoriaComboBoxRenderer());
        jComboBoxCategoria.setModel(defaultComboBox);
    }
    
    public void boxMunicipio(ArrayList<Municipio> lista) throws Exception {
        DefaultComboBoxModel<Municipio> defaultComboBox = new DefaultComboBoxModel<>();
        Municipio objeto = new Municipio();
        objeto.setNome("-SELECIONE-");
        defaultComboBox.addElement(objeto);
        for (Municipio objetoMunicipio : lista) {
            defaultComboBox.addElement(objetoMunicipio);
        }
        jComboBoxMunicipio.setRenderer(new CategoriaComboBoxRenderer());
        jComboBoxMunicipio.setModel(defaultComboBox);
    }
    
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        Denuncia denuncia = new Denuncia();
        Categoria categoria = new Categoria();
        Municipio municipio = new Municipio();
        if(jCheckBoxProtocolo.isSelected()) denuncia.setProtocolo(jTextFieldBuscarProtocolo.getText());
        if(jCheckBoxCategoria.isSelected()) denuncia.setProtocolo(jTextFieldBuscarProtocolo.getText());
        if(jCheckBoxMunicipio.isSelected()) municipio = (Municipio) jComboBoxMunicipio.getSelectedItem();
        if(jCheckBoxDataDaOcorrencia.isSelected()) denuncia.setData(jTextFieldBuscarProtocolo.getText());
        if(jCheckBoxDataDoCadastro.isSelected()) denuncia.setDataDenuncia(dataDenuncia);
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jCheckBoxProtocoloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxProtocoloStateChanged
        if (jCheckBoxProtocolo.isSelected()) {
            jTextFieldBuscarProtocolo.setEditable(true);
            
            jCheckBoxCategoria.setEnabled(false);
            jCheckBoxMunicipio.setEnabled(false);
            jCheckBoxCategoria.setEnabled(false);
            jCheckBoxDataDaOcorrencia.setEnabled(false);
            jCheckBoxDataDoCadastro.setEnabled(false);

            jCheckBoxMunicipio.setSelected(false);
            jCheckBoxCategoria.setSelected(false);
            jCheckBoxDataDaOcorrencia.setSelected(false);
            jCheckBoxDataDoCadastro.setSelected(false);
    
        } else {
            jTextFieldBuscarProtocolo.setEditable(false);
            
            jCheckBoxCategoria.setEnabled(true);
            jCheckBoxMunicipio.setEnabled(true);
            jCheckBoxCategoria.setEnabled(true);
            jCheckBoxDataDaOcorrencia.setEnabled(true);
            jCheckBoxDataDoCadastro.setEnabled(true);
  
        }
    }//GEN-LAST:event_jCheckBoxProtocoloStateChanged

    private void jCheckBoxMunicipioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxMunicipioStateChanged
        if (jCheckBoxMunicipio.isSelected()) {
            jComboBoxMunicipio.setEnabled(true);
        } else {
            jComboBoxMunicipio.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxMunicipioStateChanged

    private void jCheckBoxCategoriaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxCategoriaStateChanged
        if (jCheckBoxCategoria.isSelected()) {
            jComboBoxCategoria.setEnabled(true);
        } else {
            jComboBoxCategoria.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxCategoriaStateChanged

    private void jCheckBoxDataDaOcorrenciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxDataDaOcorrenciaStateChanged
        if (jCheckBoxDataDaOcorrencia.isSelected()) {
            jFormattedTextFieldDataOcorrencia.setEnabled(true);
        } else {
            jFormattedTextFieldDataOcorrencia.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxDataDaOcorrenciaStateChanged

    private void jCheckBoxDataDoCadastroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxDataDoCadastroStateChanged
        if (jCheckBoxDataDoCadastro.isSelected()) {
            jFormattedTextFieldDataCadastro.setEnabled(true);
        } else {
            jFormattedTextFieldDataCadastro.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxDataDoCadastroStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeBusca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckBoxCategoria;
    private javax.swing.JCheckBox jCheckBoxDataDaOcorrencia;
    private javax.swing.JCheckBox jCheckBoxDataDoCadastro;
    private javax.swing.JCheckBox jCheckBoxMunicipio;
    private javax.swing.JCheckBox jCheckBoxProtocolo;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<Municipio> jComboBoxMunicipio;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCadastro;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataOcorrencia;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparatorTitulo;
    private javax.swing.JTextField jTextFieldBuscarProtocolo;
    // End of variables declaration//GEN-END:variables
}
