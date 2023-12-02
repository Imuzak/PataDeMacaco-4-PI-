package com.patademacaco.visao;

import com.patademacaco.controle.IUsuarioControle;
import com.patademacaco.controle.UsuarioControle;
import com.patademacaco.enumeracao.TipoUsuario;
import com.patademacaco.modelo.Usuario;
import java.awt.Color;
import com.patademacaco.ferramentas.RoundedPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//@author Mariana

public class TelaLoginUsuario extends javax.swing.JFrame {
    
    IUsuarioControle usuarioControle = null;
    Usuario usuario = null;
    private boolean visible = false;

    public TelaLoginUsuario() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        ImageIcon image = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\leaf.png");
        this.setIconImage(image.getImage());
        
        try {
            usuarioControle = new UsuarioControle();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPainelLoginUsuario = new RoundedPanel(20, new Color(222, 220, 225));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jLabelAindaNaoTemCadastro = new javax.swing.JLabel();
        jLabelRealizarDenunciaAnonima = new javax.swing.JLabel();
        jFormattedTextFieldLoginCpf = new javax.swing.JFormattedTextField();
        jLabelVisible = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Denúncias de Crimes Ambientais");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setBackground(new java.awt.Color(163, 177, 138));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPainelLoginUsuario.setBackground(new java.awt.Color(163, 177, 138));
        jPainelLoginUsuario.setPreferredSize(new java.awt.Dimension(362, 441));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 36, 33));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(31, 36, 33));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CPF :");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 36, 33));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Senha :");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButtonEntrar.setBackground(new java.awt.Color(52, 78, 65));
        jButtonEntrar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonEntrar.setForeground(new java.awt.Color(156, 197, 161));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setBorder(null);
        jButtonEntrar.setBorderPainted(false);
        jButtonEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jLabelAindaNaoTemCadastro.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelAindaNaoTemCadastro.setForeground(new java.awt.Color(88, 129, 87));
        jLabelAindaNaoTemCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAindaNaoTemCadastro.setText("<HTML><U>Ainda não tem cadastro?  ></U></HTML>");
        jLabelAindaNaoTemCadastro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAindaNaoTemCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAindaNaoTemCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAindaNaoTemCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAindaNaoTemCadastroMouseExited(evt);
            }
        });

        jLabelRealizarDenunciaAnonima.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelRealizarDenunciaAnonima.setForeground(new java.awt.Color(88, 129, 87));
        jLabelRealizarDenunciaAnonima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRealizarDenunciaAnonima.setText("<HTML><U>Realizar denúncia anônima?  ></U></HTML>");
        jLabelRealizarDenunciaAnonima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelRealizarDenunciaAnonima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRealizarDenunciaAnonimaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRealizarDenunciaAnonimaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRealizarDenunciaAnonimaMouseExited(evt);
            }
        });

        try {
            jFormattedTextFieldLoginCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldLoginCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextFieldLoginCpf.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabelVisible.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabelVisible.setForeground(new java.awt.Color(31, 36, 33));
        jLabelVisible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/closed_eye_.png"))); // NOI18N
        jLabelVisible.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelVisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVisibleMouseClicked(evt);
            }
        });

        jPasswordFieldSenha.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPasswordFieldSenha.setEchoChar('\u25cf');

        javax.swing.GroupLayout jPainelLoginUsuarioLayout = new javax.swing.GroupLayout(jPainelLoginUsuario);
        jPainelLoginUsuario.setLayout(jPainelLoginUsuarioLayout);
        jPainelLoginUsuarioLayout.setHorizontalGroup(
            jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPainelLoginUsuarioLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldLoginCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelRealizarDenunciaAnonima)
                        .addComponent(jButtonEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPainelLoginUsuarioLayout.createSequentialGroup()
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jLabelVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelAindaNaoTemCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPainelLoginUsuarioLayout.setVerticalGroup(
            jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelLoginUsuarioLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jFormattedTextFieldLoginCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabelAindaNaoTemCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabelRealizarDenunciaAnonima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPainelLoginUsuario, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRealizarDenunciaAnonimaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRealizarDenunciaAnonimaMouseExited
        jLabelRealizarDenunciaAnonima.setForeground(new Color(88,129,87));
    }//GEN-LAST:event_jLabelRealizarDenunciaAnonimaMouseExited

    private void jLabelRealizarDenunciaAnonimaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRealizarDenunciaAnonimaMouseEntered
        jLabelRealizarDenunciaAnonima.setForeground(new Color(163, 177, 138));
    }//GEN-LAST:event_jLabelRealizarDenunciaAnonimaMouseEntered

    private void jLabelAindaNaoTemCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAindaNaoTemCadastroMouseExited
        jLabelAindaNaoTemCadastro.setForeground(new Color(88,129,87));
    }//GEN-LAST:event_jLabelAindaNaoTemCadastroMouseExited

    private void jLabelAindaNaoTemCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAindaNaoTemCadastroMouseEntered
        jLabelAindaNaoTemCadastro.setForeground(new Color(163, 177, 138));
    }//GEN-LAST:event_jLabelAindaNaoTemCadastroMouseEntered

    private void jLabelAindaNaoTemCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAindaNaoTemCadastroMouseClicked
        TelaCadastro tela = new TelaCadastro(TipoUsuario.DENUNCIANTE);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelAindaNaoTemCadastroMouseClicked

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        try {
            String cpf = jFormattedTextFieldLoginCpf.getText();
            String senha = new String(jPasswordFieldSenha.getPassword());
            usuario = usuarioControle.validaSenha(cpf, senha);
            AbrirTelaDenuncia(usuario);
            this.dispose();
            //AbrirTelaUsuario(usuario, new String(jPasswordFieldSenha.getPassword()));
            //LimparTela(); //necessário?
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

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

    private void jLabelRealizarDenunciaAnonimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRealizarDenunciaAnonimaMouseClicked
        try {
            Usuario anonimo = new Usuario();
            anonimo = usuarioControle.buscar("00000000000");
            TelaDenuncia tela = new TelaDenuncia(anonimo, null);
            tela.setVisible(true);
            this.dispose();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jLabelRealizarDenunciaAnonimaMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JFormattedTextField jFormattedTextFieldLoginCpf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAindaNaoTemCadastro;
    private javax.swing.JLabel jLabelRealizarDenunciaAnonima;
    private javax.swing.JLabel jLabelVisible;
    private javax.swing.JPanel jPainelLoginUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    // End of variables declaration//GEN-END:variables


public void AbrirTelaDenuncia(Usuario usuario) {
    TelaListagem tela = new TelaListagem(usuario);
    tela.setVisible(true);
}

//public void AbrirTelaUsuario(Usuario usuario, String senha) {
//    TelaCadastro tela = new TelaCadastro(usuario, senha);
//    tela.setVisible(true);
//    this.dispose();
//}

//public void LimparTela() {
//    jFormattedTextFieldLoginCpf.setText("");
//    jPasswordFieldSenha.setText("");
//}

}
