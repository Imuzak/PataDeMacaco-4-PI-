package com.patademacaco.visao;

import com.patademacaco.controle.DenunciaControle;
import com.patademacaco.controle.IDenunciaControle;
import com.patademacaco.enumeracao.Status;
import com.patademacaco.enumeracao.TipoUsuario;
import com.patademacaco.ferramentas.ImageRender;
import com.patademacaco.ferramentas.RoundedPanel;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Usuario;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//@author Mariana
 
public class TelaListagem extends javax.swing.JFrame {
    
    IDenunciaControle denunciaControle = null;
    Usuario usuario = null;

    public TelaListagem() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        ImageIcon image = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\leaf.png");
        this.setIconImage(image.getImage());
        
        jLabelTituloCpfUsuario.setText("CPF : " + "314.836.374-23");
        jLabelTituloNomeUsuario.setText("Nome : " + "kjdashfkajshfuyeiugaskjgf");
        jLabelTituloTelefoneUsuario.setText("Telefone : " + "(62)98234-1238");
        jLabelTituloEmailUsuario.setText("Email : " + "email@email");
        
        jTableListagem.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        jTableListagem.getTableHeader().setOpaque(true);
        jTableListagem.getTableHeader().setBackground(Color.white);
        
        jTableListagem.setFont(new Font("Calibri", Font.PLAIN, 18));
        jTableListagem.setRowHeight(60);
        jTableListagem.setBackground(new Color(242,242,242));
        
        try {
            denunciaControle = new DenunciaControle();
            if (denunciaControle != null) imprimirDadosNaGrid(denunciaControle.Listar());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public TelaListagem(Usuario usuario) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.usuario = usuario;
        
        jLabelTituloCpfUsuario.setText("CPF : " + usuario.getCpf());
        jLabelTituloNomeUsuario.setText("Nome : " + usuario.getNome());
        jLabelTituloTelefoneUsuario.setText("Telefone : " + usuario.getTelefone());
        jLabelTituloEmailUsuario.setText("Email : " + usuario.getEmail());
        
        jTableListagem.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        jTableListagem.getTableHeader().setOpaque(true);
        jTableListagem.getTableHeader().setBackground(Color.white);
        
        jTableListagem.setFont(new Font("Calibri", Font.PLAIN, 18));
        jTableListagem.setRowHeight(60);
        jTableListagem.setBackground(new Color(242,242,242));
        
        try {
            denunciaControle = new DenunciaControle();
            if (usuario.getTipo() == TipoUsuario.ANALISTA) imprimirDadosNaGrid(denunciaControle.Listar());
            else {
                imprimirDadosNaGrid(denunciaControle.listaFiltrada(0, usuario.getCpf(), 0, null, null, null));
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelMenuMeuUsuario = new javax.swing.JLabel();
        jLabelMenuDenuncias = new javax.swing.JLabel();
        jLabelMenuNovaDenuncia = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparatorTitulo = new javax.swing.JSeparator();
        jPanel4 = new RoundedPanel(20, new Color(255, 255, 255));
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableListagem = new javax.swing.JTable();
        jLabelTitulo1 = new javax.swing.JLabel();
        jTextFieldBuscarProtocolo = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonNovaDenuncia = new javax.swing.JButton();
        jLabelTituloCpfUsuario = new javax.swing.JLabel();
        jLabelTituloNomeUsuario = new javax.swing.JLabel();
        jLabelTituloTelefoneUsuario = new javax.swing.JLabel();
        jLabelTituloEmailUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Denúncias de Crimes Ambientais");

        jPanel5.setBackground(new java.awt.Color(218, 215, 205));

        jPanel1.setBackground(new java.awt.Color(88, 129, 87));

        jLabelMenuMeuUsuario.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabelMenuMeuUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuMeuUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuMeuUsuario.setText("Meu Usuário");
        jLabelMenuMeuUsuario.setToolTipText("Meu Usuário");
        jLabelMenuMeuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuMeuUsuarioMouseClicked(evt);
            }
        });

        jLabelMenuDenuncias.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabelMenuDenuncias.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuDenuncias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuDenuncias.setText("Denúncias");
        jLabelMenuDenuncias.setToolTipText("Denúncias");
        jLabelMenuDenuncias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuDenunciasMouseClicked(evt);
            }
        });

        jLabelMenuNovaDenuncia.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabelMenuNovaDenuncia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuNovaDenuncia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuNovaDenuncia.setText("Nova Denúncia");
        jLabelMenuNovaDenuncia.setToolTipText("Nova Denúncia");
        jLabelMenuNovaDenuncia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuNovaDenunciaMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenuDenuncias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenuNovaDenuncia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenuMeuUsuario)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMenuDenuncias, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabelMenuNovaDenuncia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelMenuMeuUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelTitulo.setText("Denúncias");
        jLabelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparatorTitulo.setForeground(new java.awt.Color(51, 153, 0));

        jPanel4.setBackground(new java.awt.Color(218, 215, 205));

        jTableListagem.setBackground(new java.awt.Color(221, 221, 221));
        jTableListagem.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTableListagem.setForeground(new java.awt.Color(0, 51, 51));
        jTableListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Protocolo", "Status", "CPF", "Nome", "Municipio", "Categoria", "SubCategoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListagemMouseClicked(evt);
            }
        });
        jScrollPaneTabela.setViewportView(jTableListagem);

        jLabelTitulo1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelTitulo1.setText("Protocolo :");
        jLabelTitulo1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldBuscarProtocolo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextFieldBuscarProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarProtocoloKeyPressed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(163, 177, 138));
        jButtonBuscar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonNovaDenuncia.setBackground(new java.awt.Color(163, 177, 138));
        jButtonNovaDenuncia.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonNovaDenuncia.setText("Nova Denúncia");
        jButtonNovaDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaDenunciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBuscarProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovaDenuncia)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo1)
                    .addComponent(jTextFieldBuscarProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNovaDenuncia)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelTituloCpfUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelTituloCpfUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jLabelTituloCpfUsuario.setText("Cpf Usuário");
        jLabelTituloCpfUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelTituloNomeUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelTituloNomeUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jLabelTituloNomeUsuario.setText("Nome Usuário");
        jLabelTituloNomeUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelTituloTelefoneUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelTituloTelefoneUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jLabelTituloTelefoneUsuario.setText("Telefone Usuário");
        jLabelTituloTelefoneUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelTituloEmailUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelTituloEmailUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jLabelTituloEmailUsuario.setText("Email Usuário");
        jLabelTituloEmailUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparatorTitulo)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelTituloCpfUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloNomeUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloTelefoneUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTituloEmailUsuario)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTituloTelefoneUsuario)
                        .addComponent(jLabelTituloEmailUsuario))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTituloCpfUsuario)
                        .addComponent(jLabelTituloNomeUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

//     imprimir na table
    public void imprimirDadosNaGrid(ArrayList<Denuncia> listaDenuncias) {
        System.out.println("tento imprimir");
        try {
            DefaultTableModel model = (DefaultTableModel) jTableListagem.getModel();
            model.setNumRows(0);
            Iterator<Denuncia> lista = listaDenuncias.iterator();
            SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            while (lista.hasNext()) {
                String[] saida = new String[7];
                Denuncia aux = lista.next();
                saida[0] = aux.getProtocolo();
                saida[1] = aux.getStatus().toString();
                saida[2] = aux.getDenunciante().getCpf();
                saida[3] = aux.getDenunciante().getNome();
                saida[4] = aux.getEndereco().getMunicipio().getNome();
                saida[5] = aux.getSubCategoria().getCategoria().getTipoAmbiental();//?
                String data = formata.format(aux.getData());
                saida[6] = data;//?
                Object[] dados = {saida[0], saida[1], saida[2], saida[3], saida[4], saida[5], saida[6]};
                model.addRow(dados);
            }
            //jTableListagem.getColumnModel().getColumn(1).setCellRenderer(new ImageRender());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public void imprimirBusca(Denuncia denuncia) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableListagem.getModel();
            model.setNumRows(0);
            SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            String[] saida = new String[7];
            saida[0] = denuncia.getProtocolo();
            saida[1] = denuncia.getStatus().toString();
            saida[2] = denuncia.getDenunciante().getCpf();
            saida[3] = denuncia.getDenunciante().getNome();
            saida[4] = denuncia.getEndereco().getMunicipio().getNome() + " - " + denuncia.getEndereco().getMunicipio().getUf();
            saida[5] = denuncia.getSubCategoria().getCategoria().getTipoAmbiental();//?
            String data = formata.format(denuncia.getData());
            saida[6] = data;//?
            Object[] dados = {saida[0], saida[1], saida[2], saida[3], saida[4], saida[5], saida[6]};
            model.addRow(dados);
            //jTableListagem.getColumnModel().getColumn(1).setCellRenderer(new ImageRender());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    private void jLabelMenuMeuUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMeuUsuarioMouseClicked
        TelaCadastro tela = new TelaCadastro(usuario);
        tela.setVisible(true);
    }//GEN-LAST:event_jLabelMenuMeuUsuarioMouseClicked

    private void jLabelMenuDenunciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuDenunciasMouseClicked
        TelaListagem tela = new TelaListagem(usuario);
        tela.setVisible(true);
    }//GEN-LAST:event_jLabelMenuDenunciasMouseClicked

    private void jLabelMenuNovaDenunciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuNovaDenunciaMouseClicked
        TelaDenuncia tela = new TelaDenuncia(usuario, this);
        tela.setVisible(true);
    }//GEN-LAST:event_jLabelMenuNovaDenunciaMouseClicked

    private void jTextFieldBuscarProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProtocoloKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && (jTextFieldBuscarProtocolo.getText() != null || jTextFieldBuscarProtocolo.getText() != "")) {
            System.out.println(jTextFieldBuscarProtocolo.getText());
        }
    }//GEN-LAST:event_jTextFieldBuscarProtocoloKeyPressed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        TelaDeBusca telaBusca = new TelaDeBusca(usuario, this);
        telaBusca.setVisible(true);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonNovaDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaDenunciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovaDenunciaActionPerformed

    private void jTableListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListagemMouseClicked
        DefaultTableModel modelDenuncias = (DefaultTableModel)jTableListagem.getModel();
        int SelectedRowIndex = jTableListagem.getSelectedRow();
        String protocolo = modelDenuncias.getValueAt(SelectedRowIndex, 0).toString();
        try{
            Denuncia objeto = denunciaControle.Buscar(protocolo);
//            if(usuario.getTipo() == TipoUsuario.ANALISTA) {
//                //objeto.setAnalista(usuario);
//                objeto.setStatus(Status.ANDAMENTO);
//                denunciaControle.Alterar(objeto);
//            }
            TelaDenuncia telaDenuncia = new TelaDenuncia(usuario, objeto, this);
            telaDenuncia.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
        
    }//GEN-LAST:event_jTableListagemMouseClicked

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
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonNovaDenuncia;
    private javax.swing.JLabel jLabelMenuDenuncias;
    private javax.swing.JLabel jLabelMenuMeuUsuario;
    private javax.swing.JLabel jLabelMenuNovaDenuncia;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTituloCpfUsuario;
    private javax.swing.JLabel jLabelTituloEmailUsuario;
    private javax.swing.JLabel jLabelTituloNomeUsuario;
    private javax.swing.JLabel jLabelTituloTelefoneUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparatorTitulo;
    private javax.swing.JTable jTableListagem;
    private javax.swing.JTextField jTextFieldBuscarProtocolo;
    // End of variables declaration//GEN-END:variables
}
