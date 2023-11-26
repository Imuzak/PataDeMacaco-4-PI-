package com.patademacaco.visao;

import com.patademacaco.controle.IUsuarioControle;
import com.patademacaco.controle.UsuarioControle;
import com.patademacaco.modelo.Usuario;
import static com.patademacaco.ferramentas.SenhaHashing.doHashing;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

// @author Mariana
 
public class TelaDeletarUsuario extends javax.swing.JFrame {

    IUsuarioControle usuarioControle = null;
    Usuario usuario = null;
    TelaCadastro telaCadastro = null;
    private boolean visible = false;
    
    public TelaDeletarUsuario() {
        initComponents();
        try {
            usuarioControle = new UsuarioControle();
        }catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public TelaDeletarUsuario(Usuario usuario, TelaCadastro telaCadastro) {
        initComponents();
        this.usuario = usuario;
        this.telaCadastro = telaCadastro;
        try {
            usuarioControle = new UsuarioControle();
        }catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelVisible = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/padlock.png"))); // NOI18N

        jPasswordFieldSenha.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPasswordFieldSenha.setEchoChar('\u25cf');

        jLabelVisible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/closed_eye_.png"))); // NOI18N
        jLabelVisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVisibleMouseClicked(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonOk.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelVisible, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButtonOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelVisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVisibleMouseClicked
        if (visible) {
            visible = false;
            ImageIcon imageClosedEye = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\closed_eye_.png");
            jLabelVisible.setIcon(imageClosedEye);
            jPasswordFieldSenha.setEchoChar('\u25CF'); 
        } else {
            visible = true;
            ImageIcon imageOpenEye = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\open_eye_.png");
            jLabelVisible.setIcon(imageOpenEye);
            jPasswordFieldSenha.setEchoChar((char) 0); 
        }
    }//GEN-LAST:event_jLabelVisibleMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        if (usuario != null) {
            try {
                if (UsuarioControle.validaSenha(usuario.getSenha(), doHashing(new String(jPasswordFieldSenha.getPassword())))) {
                    usuarioControle.deletar(usuario);
                    JOptionPane.showMessageDialog(this,"Usuário deletado.");
                    TelaLoginUsuario tela = new TelaLoginUsuario();
                    tela.setVisible(true);
                    telaCadastro.dispose();
                    this.dispose();
                } else {
                    throw new Exception("Senha incorreta.");
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeletarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelVisible;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    // End of variables declaration//GEN-END:variables
}
