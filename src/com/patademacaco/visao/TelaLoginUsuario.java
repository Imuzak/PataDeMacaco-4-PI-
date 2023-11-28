package com.patademacaco.visao;

import com.patademacaco.controle.IUsuarioControle;
import com.patademacaco.controle.UsuarioControle;
import com.patademacaco.enumeracao.TipoUsuario;
import static com.patademacaco.ferramentas.SenhaHashing.doHashing;
import com.patademacaco.modelo.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
        jButtonEntrar.setBorder(new RoundedBorder(20));
        jButtonEntrar.setRolloverEnabled(false);
        try {
            usuarioControle = new UsuarioControle();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPainelLoginUsuario = new RoundedPanel(15, new Color(222, 220, 225));
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

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 36, 33));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(31, 36, 33));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CPF :");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 36, 33));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Senha :");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButtonEntrar.setBackground(new java.awt.Color(52, 78, 65));
        jButtonEntrar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonEntrar.setForeground(new java.awt.Color(156, 197, 161));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setBorder(null);
        jButtonEntrar.setBorderPainted(false);
        jButtonEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseExited(evt);
            }
        });
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
            .addGroup(jPainelLoginUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jFormattedTextFieldLoginCpf, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelLoginUsuarioLayout.createSequentialGroup()
                        .addGroup(jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonEntrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAindaNaoTemCadastro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRealizarDenunciaAnonima, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPainelLoginUsuarioLayout.setVerticalGroup(
            jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelLoginUsuarioLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jFormattedTextFieldLoginCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addGroup(jPainelLoginUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabelAindaNaoTemCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRealizarDenunciaAnonima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(147, 321, 155, 267);
        jPanel1.add(jPainelLoginUsuario, gridBagConstraints);

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
        TelaCadastro tela = new TelaCadastro();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelAindaNaoTemCadastroMouseClicked

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        try {
            String cpf = jFormattedTextFieldLoginCpf.getText();
            String senha = doHashing(new String(jPasswordFieldSenha.getPassword()));
            usuario = usuarioControle.buscar(cpf);
            if (usuario != null) {
                if (UsuarioControle.validaSenha(usuario.getSenha(), senha)) {
                    AbrirTelaNovaDenuncia(usuario);
                    //AbrirTelaUsuario(usuario, new String(jPasswordFieldSenha.getPassword()));
                } else {
                    throw new Exception("Senha incorreta.");
                }
            }
            LimparTela();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseExited
        jButtonEntrar.setBackground(new Color(52,78,65));
    }//GEN-LAST:event_jButtonEntrarMouseExited

    private void jButtonEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseEntered
        jButtonEntrar.setBackground(new Color(58, 90, 64));
    }//GEN-LAST:event_jButtonEntrarMouseEntered

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
class RoundedPanel extends JPanel{
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }

public class RoundJTextField extends JTextField {
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(true); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
}

public class RoundJFormattedTextField extends JFormattedTextField {
    private Shape shape;

    public RoundJFormattedTextField(Object value, int size) {
        super(value);
        setOpaque(true);
        setBorder(BorderFactory.createEmptyBorder()); // Remove the default border
        setHorizontalAlignment(JTextField.LEFT); // Center text

        // Customize the formatter as needed (e.g., for numbers, dates, etc.)
        // DefaultFormatter formatter = new DefaultFormatter();
        // formatter.setOverwriteMode(false);
        // setFormatter(formatter);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}


private static class RoundedBorder implements Border {
    private int radius;
    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

public void AbrirTelaNovaDenuncia(Usuario usuario) {
    TelaNovaDenuncia tela = new TelaNovaDenuncia(usuario);
    tela.setVisible(true);
    this.dispose();
}

public void AbrirTelaUsuario(Usuario usuario, String senha) {
    TelaCadastro tela = new TelaCadastro(usuario, senha);
    tela.setVisible(true);
    this.dispose();
}

public void LimparTela() {
    jFormattedTextFieldLoginCpf.setText("");
    jPasswordFieldSenha.setText("");
}

}
