package com.patademacaco.visao;

import com.patademacaco.controle.ICategoriaControle;
import com.patademacaco.controle.CategoriaControle;
import com.patademacaco.controle.DenunciaControle;
import com.patademacaco.controle.IDenunciaControle;
import com.patademacaco.controle.IUsuarioControle;
import com.patademacaco.controle.UsuarioControle;
import com.patademacaco.enumeracao.Status;
import com.patademacaco.enumeracao.TipoUsuario;
import com.patademacaco.ferramentas.CategoriaComboBoxRenderer;
import com.patademacaco.ferramentas.CustomScrollBarUI;
import com.patademacaco.ferramentas.MunicipioComboBoxRenderer;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.patademacaco.ferramentas.RoundedPanel;
import com.patademacaco.ferramentas.SubCategoriaComboBoxRenderer;
import com.patademacaco.modelo.Categoria;
import com.patademacaco.modelo.Denuncia;
import com.patademacaco.modelo.Endereco;
import com.patademacaco.modelo.Fotos;
import com.patademacaco.modelo.Municipio;
import com.patademacaco.modelo.SubCategoria;
import com.patademacaco.modelo.Usuario;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

//@author Mariana

public class TelaDenuncia extends javax.swing.JFrame {

    private Usuario usuario = null;
    private Denuncia denuncia = null;
    private Fotos fotos = new Fotos();
    private int controleImagens = 1;
    private String imagem1 = "sem foto";
    private String imagem2 = "sem foto";
    private String imagem3 = "sem foto";
    private String imagem4 = "sem foto";
    private TelaListagem telaListagem = null;
    private ICategoriaControle categoriaControle = null;
    private IDenunciaControle denunciaControle = null;
    private IUsuarioControle usuarioControle = null;
    private SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
    //TelaListagem telaListagem = null;

    public TelaDenuncia() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        ImageIcon image = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\leaf.png");
        this.setIconImage(image.getImage());
        denuncia = new Denuncia();
        
        jScrollPanePrincipal.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPanePrincipal.setDoubleBuffered(true);
        jScrollPanePrincipal.getVerticalScrollBar().setUnitIncrement(10);
        
        jComboBoxSubcategoria.setEditable(false);
        jFormattedTextFieldCpf.setEditable(false);
        jTextFieldNome.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldTelefone.setEditable(false);
        
        try{
            categoriaControle = new CategoriaControle();
            denunciaControle = new DenunciaControle();
            usuarioControle = new UsuarioControle();
            boxCategoria(categoriaControle.ListarCategorias());
            boxMunicipio(denunciaControle.ListarMunicipio());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public TelaDenuncia(Usuario usuario, TelaListagem telaListagem) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.usuario = usuario;
        this.telaListagem = telaListagem;
        denuncia = new Denuncia();
        if(usuario.getTipo() == TipoUsuario.DENUNCIANTE ){
            jButtonEditar.setVisible(false);
            if(!usuario.getNome().equals("Anonimo")){
                jTextFieldNome.setText(usuario.getNome());
                jTextFieldEmail.setText(usuario.getEmail());
                jTextFieldTelefone.setText(usuario.getTelefone());
                jFormattedTextFieldCpf.setText(usuario.getCpf());
            }
        }
        ImageIcon image = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\leaf.png");
        this.setIconImage(image.getImage());

        jScrollPanePrincipal.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPanePrincipal.setDoubleBuffered(true);
        jScrollPanePrincipal.getVerticalScrollBar().setUnitIncrement(10);
        
        jComboBoxSubcategoria.setEnabled(false);
        jFormattedTextFieldCpf.setEditable(false);
        jTextFieldNome.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldTelefone.setEditable(false);
        
        try{
            categoriaControle = new CategoriaControle();
            denunciaControle = new DenunciaControle();
            usuarioControle = new UsuarioControle();
            boxCategoria(categoriaControle.ListarCategorias());
            boxMunicipio(denunciaControle.ListarMunicipio());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
 
    }
    
    public TelaDenuncia(Usuario usuario, Denuncia denuncia, TelaListagem telaListagem) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.usuario = usuario;
        this.telaListagem = telaListagem;
        this.denuncia = denuncia;
        if(usuario.getTipo() == TipoUsuario.ANALISTA){
            jButtonEnviar.setText("FINALIZAR");
        }
        ImageIcon image = new ImageIcon(".\\src\\com\\patademacaco\\imagens\\icones\\leaf.png");
        this.setIconImage(image.getImage());

        jScrollPanePrincipal.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPanePrincipal.setDoubleBuffered(true);
        jScrollPanePrincipal.getVerticalScrollBar().setUnitIncrement(10);
        
        
        TravarCampos();
        try{
            categoriaControle = new CategoriaControle();
            denunciaControle = new DenunciaControle();
            usuarioControle = new UsuarioControle();
            boxCategoria(categoriaControle.ListarCategorias());
            boxMunicipio(denunciaControle.ListarMunicipio());
            
            //Preenche o campo das fotos
            ArrayList<String> urls = denuncia.getFotos().getUrls();
            setImagemLabel(jLabelImagem1, urls.get(0));
            if(urls.size() >= 2) setImagemLabel(jLabelImagem2, urls.get(1));
            if(urls.size() >= 3) setImagemLabel(jLabelImagem3, urls.get(2));
            if(urls.size() == 4) setImagemLabel(jLabelImagem4, urls.get(3));
            
            //Preenche a tela Denuncia com as informações da denuncia selecionada
            jComboBoxMunicipio.setSelectedItem(denuncia.getEndereco().getMunicipio());
            jComboBoxCategoria.setSelectedItem(denuncia.getSubCategoria().getCategoria());
            jComboBoxSubcategoria.setSelectedItem(denuncia.getSubCategoria());
            jFormattedTextFieldCep.setText(denuncia.getEndereco().getCep());
            jFormattedTextFieldDataOcorrencia.setText(formata.format(denuncia.getData()));
            jLabelNumeroDoProtocolo.setText(denuncia.getProtocolo());
            jLabelStatusAtual.setText(denuncia.getStatus().toString());
            jTextAreaRelatoDoOcorrido.setText(denuncia.getDescricao());
            jTextAreaSubCategoria.setText(denuncia.getSubCategoria().getSubTipo());
            jTextFieldBairro.setText(denuncia.getEndereco().getBairro());
            jTextFieldCoordenadas.setText(denuncia.getEndereco().getCoordenada());
            jTextFieldEmail.setText(denuncia.getDenunciante().getEmail());
            jTextFieldLogradouro.setText(denuncia.getEndereco().getLogradouro());
            jTextFieldNome.setText(denuncia.getDenunciante().getNome());
            jTextFieldPontoDeReferencia.setText(denuncia.getEndereco().getPontoDeReferencia());
            jTextFieldPossivelAutor.setText(denuncia.getAutorCrime());
            jTextFieldTelefone.setText(denuncia.getDenunciante().getTelefone());
            jTextParecer.setText(denuncia.getParecer());
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
 
    }
    
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
    
    public void boxSubCategoria(ArrayList<SubCategoria> lista) throws Exception {
        DefaultComboBoxModel<SubCategoria> defaultComboBox = new DefaultComboBoxModel<>();
        SubCategoria objeto = new SubCategoria();
        objeto.setSubTipoResumo("-SELECIONE-");
        defaultComboBox.addElement(objeto);
        for (SubCategoria objetoSubCategoria : lista) {
            defaultComboBox.addElement(objetoSubCategoria);
        }
        jComboBoxSubcategoria.setRenderer(new SubCategoriaComboBoxRenderer());
        jComboBoxSubcategoria.setModel(defaultComboBox);
    }
    
    public void boxMunicipio(ArrayList<Municipio> lista) throws Exception {
        DefaultComboBoxModel<Municipio> defaultComboBox = new DefaultComboBoxModel<>();
        Municipio objeto = new Municipio();
        objeto.setNome("-SELECIONE-");
        defaultComboBox.addElement(objeto);
        for (Municipio objetoMunicipio : lista) {
            defaultComboBox.addElement(objetoMunicipio);
        }
        jComboBoxMunicipio.setRenderer(new MunicipioComboBoxRenderer());
        jComboBoxMunicipio.setModel(defaultComboBox);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanePrincipal = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelMenuMeuUsuario1 = new javax.swing.JLabel();
        jLabelMenuDenuncias1 = new javax.swing.JLabel();
        jLabelMenuNovaDenuncia1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonEnviar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel4 = new RoundedPanel(20, new Color(255,255,255));
        jLabelProtocolo = new javax.swing.JLabel();
        jLabelNumeroDoProtocolo = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelStatusAtual = new javax.swing.JLabel();
        jLabelCep = new javax.swing.JLabel();
        jTextFieldCoordenadas = new javax.swing.JTextField();
        jComboBoxMunicipio = new javax.swing.JComboBox<>();
        jLabelPontoDeReferencia = new javax.swing.JLabel();
        jTextFieldPontoDeReferencia = new javax.swing.JTextField();
        jLabelEndereco = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelMunicipio = new javax.swing.JLabel();
        jLabelImagens = new javax.swing.JLabel();
        jButtonEscolherArquivo = new javax.swing.JButton();
        jPanelImagens = new RoundedPanel(20, new Color(163,177,138));
        jLabelImagem1 = new javax.swing.JLabel();
        jLabelImagem2 = new javax.swing.JLabel();
        jLabelImagem3 = new javax.swing.JLabel();
        jLabelImagem4 = new javax.swing.JLabel();
        jPanel3 = new RoundedPanel(20, new Color(204,204,204));
        jLabelCpf = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        jLabelParecerTecnico = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextParecer = new javax.swing.JTextArea();
        jLabelRelatoDoOcorrido = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaRelatoDoOcorrido = new javax.swing.JTextArea();
        jLabelInfoDenunciante = new javax.swing.JLabel();
        jLabelAnonimo = new javax.swing.JLabel();
        jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataOcorrencia = new javax.swing.JFormattedTextField();
        jLabelDataOcorrido = new javax.swing.JLabel();
        Coordenadas = new javax.swing.JLabel();
        jTextFieldPossivelAutor = new javax.swing.JTextField();
        Coordenadas1 = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabelSubCategoria1 = new javax.swing.JLabel();
        jComboBoxSubcategoria = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaSubCategoria = new javax.swing.JTextArea();
        jLabelcamposObrigatorios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Denúncias de Crimes Ambientais");
        setSize(new java.awt.Dimension(1080, 720));

        jScrollPanePrincipal.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel5.setBackground(new java.awt.Color(218, 215, 205));

        jPanel2.setBackground(new java.awt.Color(88, 129, 87));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelMenuMeuUsuario1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabelMenuMeuUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuMeuUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuMeuUsuario1.setText("Meu Usuário");
        jLabelMenuMeuUsuario1.setToolTipText("Meu Usuário");
        jLabelMenuMeuUsuario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuMeuUsuario1MouseClicked(evt);
            }
        });

        jLabelMenuDenuncias1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabelMenuDenuncias1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuDenuncias1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuDenuncias1.setText("Denúncias");
        jLabelMenuDenuncias1.setToolTipText("Denúncias");
        jLabelMenuDenuncias1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuDenuncias1MouseClicked(evt);
            }
        });

        jLabelMenuNovaDenuncia1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabelMenuNovaDenuncia1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuNovaDenuncia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuNovaDenuncia1.setText("Nova Denúncia");
        jLabelMenuNovaDenuncia1.setToolTipText("Nova Denúncia");
        jLabelMenuNovaDenuncia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuNovaDenuncia1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1638, Short.MAX_VALUE)
                .addComponent(jLabelMenuDenuncias1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenuNovaDenuncia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenuMeuUsuario1)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMenuDenuncias1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabelMenuNovaDenuncia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelMenuMeuUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator4))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabel1.setText("Denúncia");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparator1.setForeground(new java.awt.Color(51, 153, 0));

        jButtonEnviar.setBackground(new java.awt.Color(163, 177, 138));
        jButtonEnviar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(163, 177, 138));
        jButtonEditar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(163, 177, 138));
        jButtonCancelar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButtonCancelar.setText("Voltar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(218, 215, 205));

        jLabelProtocolo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelProtocolo.setText("Protocolo");
        jLabelProtocolo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelNumeroDoProtocolo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelNumeroDoProtocolo.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabelNumeroDoProtocolo.setForeground(new java.awt.Color(153, 153, 153));
        jLabelNumeroDoProtocolo.setText("o número do protocolo aparecerá aqui");
        jLabelNumeroDoProtocolo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelStatus.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelStatus.setText("Status");
        jLabelStatus.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelStatusAtual.setBackground(new java.awt.Color(153, 153, 153));
        jLabelStatusAtual.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabelStatusAtual.setForeground(new java.awt.Color(153, 153, 153));
        jLabelStatusAtual.setText("o status da denúncia");
        jLabelStatusAtual.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelCep.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelCep.setText("CEP *");
        jLabelCep.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldCoordenadas.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jComboBoxMunicipio.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jComboBoxMunicipio.setToolTipText("");

        jLabelPontoDeReferencia.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelPontoDeReferencia.setText("Ponto de Referência ");
        jLabelPontoDeReferencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldPontoDeReferencia.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabelEndereco.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelEndereco.setText("Logradouro *");
        jLabelEndereco.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldLogradouro.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabelBairro.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelBairro.setText("Bairro *");
        jLabelBairro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldBairro.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabelMunicipio.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelMunicipio.setText("Município *");
        jLabelMunicipio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelImagens.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelImagens.setText("Imagens *");
        jLabelImagens.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButtonEscolherArquivo.setText("Escolher Arquivo");
        jButtonEscolherArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolherArquivoActionPerformed(evt);
            }
        });

        jLabelImagem1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelImagem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/add.png"))); // NOI18N
        jLabelImagem1.setText("Adicionar Imagem");
        jLabelImagem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImagem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagem1MouseClicked(evt);
            }
        });

        jLabelImagem2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelImagem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/add.png"))); // NOI18N
        jLabelImagem2.setText("Adicionar Imagem");
        jLabelImagem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImagem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagem2MouseClicked(evt);
            }
        });

        jLabelImagem3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelImagem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/add.png"))); // NOI18N
        jLabelImagem3.setText("Adicionar Imagem");
        jLabelImagem3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImagem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagem3MouseClicked(evt);
            }
        });

        jLabelImagem4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelImagem4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/patademacaco/imagens/icones/add.png"))); // NOI18N
        jLabelImagem4.setText("Adicionar Imagem");
        jLabelImagem4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImagem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagem4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagensLayout = new javax.swing.GroupLayout(jPanelImagens);
        jPanelImagens.setLayout(jPanelImagensLayout);
        jPanelImagensLayout.setHorizontalGroup(
            jPanelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelImagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelImagem4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelImagensLayout.setVerticalGroup(
            jPanelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelImagem4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCpf.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCpf.setText("CPF :");
        jLabelCpf.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldNome.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldNome.setEnabled(false);

        jTextFieldEmail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldEmail.setEnabled(false);

        jTextFieldTelefone.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldTelefone.setEnabled(false);

        jLabelNome.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelNome.setText("Nome :");
        jLabelNome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelEmail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelEmail.setText("Email :");
        jLabelEmail.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelTelefone.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelTelefone.setText("Telefone :");
        jLabelTelefone.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        try {
            jFormattedTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCpf.setEnabled(false);
        jFormattedTextFieldCpf.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelParecerTecnico.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelParecerTecnico.setText("Parecer Técnico");
        jLabelParecerTecnico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextParecer.setColumns(20);
        jTextParecer.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextParecer.setRows(5);
        jTextParecer.setEnabled(false);
        jScrollPane2.setViewportView(jTextParecer);

        jLabelRelatoDoOcorrido.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelRelatoDoOcorrido.setText("Relato do Ocorrido *");
        jLabelRelatoDoOcorrido.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextAreaRelatoDoOcorrido.setColumns(20);
        jTextAreaRelatoDoOcorrido.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextAreaRelatoDoOcorrido.setRows(5);
        jScrollPane3.setViewportView(jTextAreaRelatoDoOcorrido);

        jLabelInfoDenunciante.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelInfoDenunciante.setText("Informações do Denunciante");

        jLabelAnonimo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelAnonimo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelAnonimo.setForeground(new java.awt.Color(153, 153, 153));
        jLabelAnonimo.setText("** ANÔNIMO");
        jLabelAnonimo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        try {
            jFormattedTextFieldCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCep.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        try {
            jFormattedTextFieldDataOcorrencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataOcorrencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabelDataOcorrido.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelDataOcorrido.setText("Data do Ocorrido *");
        jLabelDataOcorrido.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Coordenadas.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        Coordenadas.setText("Coordenadas ");
        Coordenadas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jTextFieldPossivelAutor.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        Coordenadas1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        Coordenadas1.setText("Possivel Autor do Crime");
        Coordenadas1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelCategoria.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelCategoria.setText("Categoria*");
        jLabelCategoria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jComboBoxCategoria.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jComboBoxCategoria.setToolTipText("");
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });

        jLabelSubCategoria1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelSubCategoria1.setText("Subcategoria*");
        jLabelSubCategoria1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jComboBoxSubcategoria.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jComboBoxSubcategoria.setToolTipText("");
        jComboBoxSubcategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSubcategoriaItemStateChanged(evt);
            }
        });

        jTextAreaSubCategoria.setEditable(false);
        jTextAreaSubCategoria.setColumns(20);
        jTextAreaSubCategoria.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextAreaSubCategoria.setRows(5);
        jScrollPane4.setViewportView(jTextAreaSubCategoria);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelProtocolo)
                            .addComponent(jLabelStatus)
                            .addComponent(jLabelBairro)
                            .addComponent(jLabelEndereco)
                            .addComponent(jLabelPontoDeReferencia)
                            .addComponent(jLabelCep)
                            .addComponent(jLabelDataOcorrido)
                            .addComponent(Coordenadas)
                            .addComponent(Coordenadas1))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStatusAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNumeroDoProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jFormattedTextFieldDataOcorrencia, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelMunicipio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelSubCategoria1)
                                            .addComponent(jLabelCategoria)))
                                    .addComponent(jTextFieldCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPontoDeReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPossivelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabelImagens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEscolherArquivo))
                            .addComponent(jLabelInfoDenunciante)
                            .addComponent(jLabelParecerTecnico)
                            .addComponent(jLabelAnonimo)
                            .addComponent(jLabelRelatoDoOcorrido))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelImagens, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProtocolo)
                    .addComponent(jLabelNumeroDoProtocolo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatus)
                    .addComponent(jLabelStatusAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataOcorrido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCep)
                    .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMunicipio)
                    .addComponent(jComboBoxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEndereco)
                    .addComponent(jLabelSubCategoria1)
                    .addComponent(jComboBoxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPontoDeReferencia)
                            .addComponent(jTextFieldPontoDeReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Coordenadas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPossivelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Coordenadas1))
                        .addGap(99, 99, 99)
                        .addComponent(jLabelRelatoDoOcorrido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelImagens)
                        .addComponent(jButtonEscolherArquivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelInfoDenunciante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAnonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelParecerTecnico)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jLabelcamposObrigatorios.setBackground(new java.awt.Color(153, 153, 153));
        jLabelcamposObrigatorios.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabelcamposObrigatorios.setForeground(new java.awt.Color(153, 153, 153));
        jLabelcamposObrigatorios.setText("Campos Obrigatórios *");
        jLabelcamposObrigatorios.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabelcamposObrigatorios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1969, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jButtonCancelar)
                                        .addGap(1669, 1669, 1669)
                                        .addComponent(jButtonEditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonEnviar))
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelcamposObrigatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEnviar)
                    .addComponent(jButtonEditar))
                .addGap(41, 41, 41))
        );

        jScrollPanePrincipal.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1952, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void TravarCampos(){
        jTextAreaRelatoDoOcorrido.setEditable(false);
        jTextFieldBairro.setEditable(false);
        jTextFieldCoordenadas.setEditable(false);
        jTextFieldLogradouro.setEditable(false);
        jTextFieldPontoDeReferencia.setEditable(false);
        jTextFieldPossivelAutor.setEditable(false);
        jFormattedTextFieldCep.setEditable(false);
        jFormattedTextFieldDataOcorrencia.setEditable(false);
        jComboBoxCategoria.setEnabled(false);
        jComboBoxMunicipio.setEnabled(false);
        jComboBoxSubcategoria.setEnabled(false);
    }
    
    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try{
            
            if(usuario.getTipo() == TipoUsuario.ANALISTA){
            String parecer = jTextParecer.getText();
            denuncia.setParecer(parecer);
            denuncia.setStatus(Status.FINALIZADO);
            denunciaControle.Alterar(denuncia);
            telaListagem.imprimirDadosNaGrid(denunciaControle.Listar());
            }else{
                //data
                Date dataOcorrido = formata.parse(jFormattedTextFieldDataOcorrencia.getText());
                Date dataDenuncia = new Date();
                //Endereco
                Endereco endereco = new Endereco();
                endereco.setCep(jFormattedTextFieldCep.getText());
                endereco.setBairro(jTextFieldBairro.getText());
                endereco.setLogradouro(jTextFieldLogradouro.getText());
                endereco.setCoordenada(jTextFieldCoordenadas.getText());
                endereco.setPontoDeReferencia(jTextFieldPontoDeReferencia.getText());
                Municipio municipio = new Municipio();
                municipio = (Municipio) jComboBoxMunicipio.getSelectedItem();
                endereco.setMunicipio(municipio);
                System.out.println("endereço settado");
                //Possivel Autor
                String possivelAutor = jTextFieldPossivelAutor.getText();
                String descricao = jTextAreaRelatoDoOcorrido.getText();
                System.out.println("descricao");
                //Categoria e Subcategoria
                SubCategoria subcategoria = new SubCategoria();
                subcategoria = (SubCategoria) jComboBoxSubcategoria.getSelectedItem();
                System.out.println("categoria coletada");
                denuncia.setEndereco(endereco);
                fotos.addUrl(imagem1);
                if(!imagem2.equalsIgnoreCase("sem foto"))fotos.addUrl(imagem2);
                if(!imagem3.equalsIgnoreCase("sem foto"))fotos.addUrl(imagem3);
                if(!imagem4.equalsIgnoreCase("sem foto"))fotos.addUrl(imagem4);
                System.out.println("imagens coletadas");
                denuncia.setFotos(fotos);
                denuncia.setDenunciante(usuario);
                denuncia.setData(dataOcorrido);
                denuncia.setDataDenuncia(dataDenuncia);
                denuncia.setAutorCrime(possivelAutor);
                denuncia.setDescricao(descricao);
                denuncia.setSubCategoria(subcategoria);
                System.out.println("itens settados");
                String protocolo = denunciaControle.Cadastrar(denuncia);
                System.out.println("protocolo coletado");
                jLabelNumeroDoProtocolo.setText(protocolo);
                jLabelStatusAtual.setText(denuncia.getStatus().toString());
                jButtonEnviar.setEnabled(false);
                if(!usuario.getNome().equalsIgnoreCase("Anonimo"))telaListagem.imprimirDadosNaGrid(denunciaControle.listaFiltrada(0, usuario.getCpf(), 0, null, null, null));
            }
            TravarCampos();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try{
            SubCategoria subCategoria = (SubCategoria) jComboBoxSubcategoria.getSelectedItem();
            denuncia.setSubCategoria(subCategoria);
            String parecer = jTextParecer.getText();
            denuncia.setParecer(parecer);
            denunciaControle.Alterar(denuncia);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
 
    public void setImagemLabel(javax.swing.JLabel jlabel, String nomeDoArquivo){
            ImageIcon icon = new ImageIcon(nomeDoArquivo);
            icon.setImage(icon.getImage().getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), 1));
            jlabel.setIcon(icon);
    }
    
    private void jButtonEscolherArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolherArquivoActionPerformed
        try {
            if (controleImagens <= 4) {
                JFileChooser fc = new JFileChooser("./src/javaapplication2");
                File buscar = new File("./src/javaapplication2/imagem1");

                fc.setCurrentDirectory(buscar);
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.showOpenDialog(this);
                File arquivo = fc.getSelectedFile();
                String nomeDoArquivo = arquivo.getPath();
                ImageIcon iconLogo = new ImageIcon(nomeDoArquivo);
                if (controleImagens == 1) {
                    iconLogo.setImage(iconLogo.getImage().getScaledInstance(jLabelImagem1.getWidth(), jLabelImagem1.getHeight(), 1));
                    jLabelImagem1.setIcon(iconLogo);
                } else if (controleImagens == 2) {
                    iconLogo.setImage(iconLogo.getImage().getScaledInstance(jLabelImagem2.getWidth(), jLabelImagem2.getHeight(), 1));
                    jLabelImagem2.setIcon(iconLogo);
                } else if (controleImagens == 3) {
                    iconLogo.setImage(iconLogo.getImage().getScaledInstance(jLabelImagem3.getWidth(), jLabelImagem3.getHeight(), 1));
                    jLabelImagem3.setIcon(iconLogo);
                } else if (controleImagens == 4) {
                    iconLogo.setImage(iconLogo.getImage().getScaledInstance(jLabelImagem4.getWidth(), jLabelImagem4.getHeight(), 1));
                    jLabelImagem4.setIcon(iconLogo);
                }
                controleImagens++;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jButtonEscolherArquivoActionPerformed

    private void jLabelImagem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagem1MouseClicked
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Escolha um Arquivo");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String imagem1 = arquivo.getPath();
            setImagemLabel(jLabelImagem1, imagem1);
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jLabelImagem1MouseClicked

    private void jLabelImagem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagem2MouseClicked
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Escolha um Arquivo");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String imagem2 = arquivo.getPath();
            setImagemLabel(jLabelImagem2, imagem2);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jLabelImagem2MouseClicked

    private void jLabelImagem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagem3MouseClicked
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Escolha um Arquivo");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String imagem3 = arquivo.getPath();
            setImagemLabel(jLabelImagem3, imagem3);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jLabelImagem3MouseClicked

    private void jLabelImagem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagem4MouseClicked
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Escolha um Arquivo");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String imagem4 = arquivo.getPath();
            setImagemLabel(jLabelImagem4, imagem4);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jLabelImagem4MouseClicked

    private void jLabelMenuMeuUsuario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMeuUsuario1MouseClicked
        //TelaCadastro tela = new TelaCadastro(usuario);
        TelaCadastro tela = new TelaCadastro();
        tela.setVisible(true);
    }//GEN-LAST:event_jLabelMenuMeuUsuario1MouseClicked

    private void jLabelMenuDenuncias1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuDenuncias1MouseClicked
        //TelaListagem tela = new TelaListagem(usuario);
        TelaListagem tela = new TelaListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_jLabelMenuDenuncias1MouseClicked

    private void jLabelMenuNovaDenuncia1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuNovaDenuncia1MouseClicked
        //TelaDenuncia tela = new TelaDenuncia(usuario);
        TelaDenuncia tela = new TelaDenuncia();
        tela.setVisible(true);
    }//GEN-LAST:event_jLabelMenuNovaDenuncia1MouseClicked

    private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaItemStateChanged
        Categoria objeto = (Categoria) jComboBoxCategoria.getSelectedItem();
        try {
            boxSubCategoria(categoriaControle.ListarSubCategorias(objeto.getId()));
            jComboBoxSubcategoria.setEnabled(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

    private void jComboBoxSubcategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubcategoriaItemStateChanged
        SubCategoria objeto = (SubCategoria) jComboBoxSubcategoria.getSelectedItem();
        try {
            jTextAreaSubCategoria.setText(objeto.getSubTipo());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jComboBoxSubcategoriaItemStateChanged

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("FileChooser.listFont", new Font("Calibri", Font.PLAIN, 16));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDenuncia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Coordenadas;
    private javax.swing.JLabel Coordenadas1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonEscolherArquivo;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<Municipio> jComboBoxMunicipio;
    private javax.swing.JComboBox<SubCategoria> jComboBoxSubcategoria;
    private javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataOcorrencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAnonimo;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataOcorrido;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelImagem1;
    private javax.swing.JLabel jLabelImagem2;
    private javax.swing.JLabel jLabelImagem3;
    private javax.swing.JLabel jLabelImagem4;
    private javax.swing.JLabel jLabelImagens;
    private javax.swing.JLabel jLabelInfoDenunciante;
    private javax.swing.JLabel jLabelMenuDenuncias1;
    private javax.swing.JLabel jLabelMenuMeuUsuario1;
    private javax.swing.JLabel jLabelMenuNovaDenuncia1;
    private javax.swing.JLabel jLabelMunicipio;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumeroDoProtocolo;
    private javax.swing.JLabel jLabelParecerTecnico;
    private javax.swing.JLabel jLabelPontoDeReferencia;
    private javax.swing.JLabel jLabelProtocolo;
    private javax.swing.JLabel jLabelRelatoDoOcorrido;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelStatusAtual;
    private javax.swing.JLabel jLabelSubCategoria1;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelcamposObrigatorios;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelImagens;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPanePrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea jTextAreaRelatoDoOcorrido;
    private javax.swing.JTextArea jTextAreaSubCategoria;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCoordenadas;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPontoDeReferencia;
    private javax.swing.JTextField jTextFieldPossivelAutor;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextArea jTextParecer;
    // End of variables declaration//GEN-END:variables

}
