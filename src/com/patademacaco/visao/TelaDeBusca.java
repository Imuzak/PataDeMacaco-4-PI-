package com.patademacaco.visao;

import java.awt.event.KeyEvent;

// @author Mariana
 
public class TelaDeBusca extends javax.swing.JFrame {

    public TelaDeBusca() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jLabelTitulo2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelTitulo2.setText("Buscar por");
        jLabelTitulo2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparatorTitulo.setForeground(new java.awt.Color(51, 153, 0));

        jCheckBoxCategoria.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxCategoria.setText("Categoria");

        jComboBoxCategoria.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FAUNA", "FLORA", "POLUIÇÃO", "ODENAMENTO URBANO E PATRIMÔNIO CULTURAL", "ADMINISTRAÇÃO AMBIENTAL" }));

        jCheckBoxProtocolo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxProtocolo.setText("Protocolo");
        jCheckBoxProtocolo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxProtocoloStateChanged(evt);
            }
        });
        jCheckBoxProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProtocoloActionPerformed(evt);
            }
        });

        jTextFieldBuscarProtocolo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldBuscarProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarProtocoloKeyPressed(evt);
            }
        });

        jCheckBoxMunicipio.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxMunicipio.setText("Município");

        jComboBoxMunicipio.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jCheckBoxDataDaOcorrencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxDataDaOcorrencia.setText("Data da Ocorrência");

        jCheckBoxDataDoCadastro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBoxDataDoCadastro.setText("Data do Cadastro da Denúncia");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
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

    private void jCheckBoxProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProtocoloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxProtocoloActionPerformed

    private void jTextFieldBuscarProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProtocoloKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && (jTextFieldBuscarProtocolo.getText() != null || jTextFieldBuscarProtocolo.getText() != "")) {
            System.out.println(jTextFieldBuscarProtocolo.getText());
        }
    }//GEN-LAST:event_jTextFieldBuscarProtocoloKeyPressed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jCheckBoxProtocoloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxProtocoloStateChanged
        if (jCheckBoxProtocolo.isSelected()) {
            jCheckBoxCategoria.setEnabled(false);
        } else {
             jCheckBoxCategoria.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBoxProtocoloStateChanged

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
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxMunicipio;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCadastro;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataOcorrencia;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparatorTitulo;
    private javax.swing.JTextField jTextFieldBuscarProtocolo;
    // End of variables declaration//GEN-END:variables
}
