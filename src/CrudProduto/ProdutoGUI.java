package CrudProduto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import tools.CentroDoMonitorMaior;
import tools.CopiaImagem;
import tools.JanelaPesquisar;
import tools.ManipulaArquivo;
import tools.MinhaJOptionPane;

public class ProdutoGUI extends JDialog {

    ImageIcon iconeCreate;
    ImageIcon iconeRetrieve;
    ImageIcon iconeUpdate;
    ImageIcon iconeDelete;
    ImageIcon iconeSave;
    ImageIcon iconeCancel;
    ImageIcon iconeListar;

    JButton btnCreate;
    JButton btnRetrieve;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnSave;
    JButton btnCancel;
    JButton btnList;
    JLabel labelId = new JLabel("Id");
    JTextField textFieldId = new JTextField();
    JLabel labelNome = new JLabel("Nome");
    JTextField textFieldNome = new JTextField();
    JLabel labelSiglaUnidadeDeMedida = new JLabel("SiglaUnidadeDeMedida");
    JTextField textFieldSiglaUnidadeDeMedida = new JTextField();
    JLabel labelQuantidade_produto = new JLabel("Quantidade_produto");
    JTextField textFieldQuantidade_produto = new JTextField();
    JLabel labelPreco_unitario = new JLabel("Preco_unitario");
    JTextField textFieldPreco_unitario = new JTextField();
    JLabel labelFoto = new JLabel("");
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String acao = "";//variavel para facilitar insert e update 
    JPanel pnCentro = new JPanel();
    JPanel pnLeste = new JPanel();
    ProdutoControlaLista cl = new ProdutoControlaLista();
    Produto produto = new Produto();

    Image imagemAux;
    String origem;
    String destino = "src/fotos/";

    private void atvBotoes(boolean c, boolean r, boolean u, boolean d) {
        btnCreate.setEnabled(c);
        btnRetrieve.setEnabled(r);
        btnUpdate.setEnabled(u);
        btnDelete.setEnabled(d);
        btnList.setEnabled(r);
    }

    public void mostrarBotoes(boolean visivel) {
        btnCreate.setVisible(visivel);
        btnRetrieve.setVisible(visivel);
        btnUpdate.setVisible(visivel);
        btnDelete.setVisible(visivel);
        btnList.setVisible(visivel);
        btnSave.setVisible(!visivel);
        btnCancel.setVisible(!visivel);
    }

    private void habilitarAtributos(boolean id, boolean nome, boolean siglaUnidadeDeMedida, boolean quantidade_produto, boolean preco_unitario) {

        if (id) {
            textFieldId.requestFocus();
            textFieldId.selectAll();
        }
        textFieldId.setEnabled(id);

        textFieldId.setEditable(id);
        textFieldNome.setEditable(nome);
        textFieldSiglaUnidadeDeMedida.setEditable(siglaUnidadeDeMedida);
        textFieldQuantidade_produto.setEditable(quantidade_produto);
        textFieldPreco_unitario.setEditable(preco_unitario);
    }

    public void zerarAtributos(int img) {
        if (img == 0) {
            origem = "/fotos/0.png";
        } else {
            origem = "/fotos/0a.png";
        }
        ImageIcon icone = new ImageIcon(getClass().getResource(origem));

        imagemAux = icone.getImage();
        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
        labelFoto.setIcon(icone);
        textFieldNome.setText("");
        textFieldSiglaUnidadeDeMedida.setText("");
        textFieldQuantidade_produto.setText("");
        textFieldPreco_unitario.setText("");
    }

    public ProdutoGUI() {
        //carregar imagens para os botões
        try {
            iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
            iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
            iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
            iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
            iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
            iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
            iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));

            btnCreate = new JButton(iconeCreate);
            btnRetrieve = new JButton(iconeRetrieve);
            btnUpdate = new JButton(iconeUpdate);
            btnDelete = new JButton(iconeDelete);
            btnSave = new JButton(iconeSave);
            btnCancel = new JButton(iconeCancel);
            btnList = new JButton(iconeListar);
        } catch (Exception e) {
            System.out.println("Não achou alguma imagem para os botões, confira o caminho e se existe a package icones");
        }
        setTitle("Cadastro de Produto");
        try {
            File arq = new File("Produto.dat"); //tenta abrir o arquivo
            if (arq.exists()) { //se o arquivo já existe, abre e lê os dados
                cl.getArquivo("Produto.dat");
            }
        } catch (Exception e) {
            System.out.println("arquivo não encontrado");
        }
        setSize(800, 600);//tamanho da janela
        setModal(true);
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        atvBotoes(false, true, false, false);
        habilitarAtributos(true, false, false, false, false);
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar Toolbar1 = new JToolBar();
        Toolbar1.add(btnRetrieve);
        Toolbar1.add(btnCreate);
        Toolbar1.add(btnUpdate);
        Toolbar1.add(btnDelete);
        Toolbar1.add(btnSave);
        Toolbar1.add(btnCancel);
        Toolbar1.add(btnList);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);  //atributos

        pnLeste.setLayout(new GridLayout(1, 1));
        pnLeste.add(labelFoto);
        pnLeste.setBackground(Color.red);

        pnCentro.setLayout(new GridLayout(5, 2));
        pnCentro.add(labelId);
        pnCentro.add(textFieldId);
        pnCentro.add(labelNome);
        pnCentro.add(textFieldNome);
        pnCentro.add(labelSiglaUnidadeDeMedida);
        pnCentro.add(textFieldSiglaUnidadeDeMedida);
        pnCentro.add(labelQuantidade_produto);
        pnCentro.add(textFieldQuantidade_produto);
        pnCentro.add(labelPreco_unitario);
        pnCentro.add(textFieldPreco_unitario);
        aviso.add(labelAviso);
        aviso.setBackground(Color.yellow);
        cp.add(Toolbar1, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnLeste, BorderLayout.EAST);
        cp.add(aviso, BorderLayout.SOUTH);
        textFieldId.requestFocus();
        textFieldId.selectAll();
        textFieldId.setBackground(Color.GREEN);
        labelAviso.setText("Digite uma placa e clic [Pesquisar]");

        //para ajustar o tamanho de uma imagem
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception e) {
            System.out.println("erro ao carregar a imagem");
        }

        textFieldSiglaUnidadeDeMedida.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("UnidadeDeMedida.dat");

                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, getBounds().x - getWidth() / 2 + getWidth() + 5, getBounds().y).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        textFieldSiglaUnidadeDeMedida.setText(aux[0]);

                    } else {
                        textFieldSiglaUnidadeDeMedida.requestFocus();
                        textFieldSiglaUnidadeDeMedida.selectAll();
                    }
                }
            }
        });

        // Listeners
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textFieldId.setText(textFieldId.getText().trim());//caso tenham sido digitados espaços
                if (textFieldId.getText().equals("")) {
                    MinhaJOptionPane myJOptionPane
                            = new MinhaJOptionPane(
                                    new Point(getBounds().x + (int) (getBounds().getWidth() / 2),
                                            getBounds().y + (int) (getBounds().getHeight() / 2)),
                                    "Deve ser informado um valor para esse campo");
                    if (myJOptionPane.getValorRetornado()) {
                        textFieldId.requestFocus();
                        textFieldId.selectAll();
                    }
                } else {
                    produto = new Produto();
                    produto.setId(Integer.valueOf(textFieldId.getText().trim()));
                    produto = cl.retrieve(produto);
                    if (produto != null) { //se encontrou na lista

                        textFieldNome.setText(produto.getNome());
                        textFieldSiglaUnidadeDeMedida.setText(produto.getSiglaUnidadeDeMedida());
                        textFieldQuantidade_produto.setText(String.valueOf(produto.getQuantidade_produto()));
                        textFieldPreco_unitario.setText(String.valueOf(produto.getPreco_unitario()));
                        atvBotoes(false, true, true, true);
                        habilitarAtributos(true, false, false, false, false);
                        labelAviso.setText("Encontrou - clic [Pesquisar], [Alterar] ou [Excluir]");
                        acao = "encontrou";
                        //para ajustar o tamanho de uma imagem
                        try {                       
                            String aux = String.valueOf(produto.getId()).trim();
                          
                            // antes de mudar era assim
                            //origem = "/fotos/" + aux + ".png";
                            //ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            
                            //inicio da mudança no código
                            origem = "src/fotos/" + aux + ".png";
                            File img = new File(origem);//ler novamente a imagem
                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            //fim da modificação
                            
                            
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception e) {
                            System.out.println("nao achou " + origem);
                            origem = "/fotos/0.png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);
                        }
                    } else {
                        atvBotoes(true, true, false, false);
                        zerarAtributos(0);
                        labelAviso.setText("Não cadastrado - clic [Inserir] ou digite outra placa [Pesquisar]");
                    }
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos(1);
                habilitarAtributos(false, true, false, true, true);
                textFieldNome.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                acao = "insert";
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "update";
                mostrarBotoes(false);
                habilitarAtributos(false, true, false, true, true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + produto.getId() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");

                    String aux = String.valueOf(produto.getId()).trim();
                    origem = "src/fotos/" + aux + ".png";
                    System.out.println(origem);
                    try {
                        File f = new File(origem);
                        if (f.exists()) {
                            f.delete();
                        }
                    } catch (Exception e) {
                        System.out.println("foto não deletada");
                    }
                    cl.excluir(produto);
                    zerarAtributos(0);
                    textFieldId.requestFocus();
                    textFieldId.selectAll();
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (acao.equals("insert")) {
                    produto = new Produto();
                    produto.setId(Integer.valueOf(textFieldId.getText()));
                    produto.setNome(textFieldNome.getText());
                    produto.setSiglaUnidadeDeMedida(textFieldSiglaUnidadeDeMedida.getText());
                    produto.setQuantidade_produto(Double.valueOf(textFieldQuantidade_produto.getText()));
                    produto.setPreco_unitario(Double.valueOf(textFieldPreco_unitario.getText()));
                    cl.inserir(produto);
                    habilitarAtributos(true, false, false, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    labelAviso.setText("Registro inserido...");
                } else {  //acao = update
                    Produto original = produto;
                    produto.setId(Integer.valueOf(textFieldId.getText()));
                    produto.setNome(textFieldNome.getText());
                    produto.setSiglaUnidadeDeMedida(textFieldSiglaUnidadeDeMedida.getText());
                    produto.setQuantidade_produto(Double.valueOf(textFieldQuantidade_produto.getText()));
                    produto.setPreco_unitario(Double.valueOf(textFieldPreco_unitario.getText()));
                    cl.atualizar(original, produto);
                    mostrarBotoes(true);
                    habilitarAtributos(true, false, false, false, false);
                    atvBotoes(false, true, false, false);
                    labelAviso.setText("Registro atualizado...");
                }
                //salvar a imagem
                destino = destino + produto.getId() + ".png";
//                    System.out.println("origem =>" + origem);
//                    System.out.println("destino =>" + destino);
                CopiaImagem.copiar(origem, destino);
                destino = "src/fotos/";
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos(0);
                atvBotoes(false, true, false, false);
                habilitarAtributos(true, false, false, false, false);
                mostrarBotoes(true);
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                acao = "list";
                ProdutoGUIListagem listagem = new ProdutoGUIListagem(cl.getLista(), getBounds().x, getBounds().y);
            }
        });

        labelFoto.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (acao.equals("insert") || acao.equals("update")) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                        File img = fc.getSelectedFile();
                        origem = fc.getSelectedFile().getAbsolutePath();
                        try {
                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception ex) {
                            System.out.println("Erro: " + ex.getMessage());
                        }
                    }

                }

            }
        });

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //antes de sair do sistema, grava os dados da lista em disco
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em disco
                cl.salvarArquivo("Produto.dat");
                // Sai da classe
                dispose();
            }
        });

        textFieldId.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldId.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldId.setBackground(Color.white);
            }
        });

        textFieldNome.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldNome.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldNome.setBackground(Color.white);
            }
        });

        textFieldSiglaUnidadeDeMedida.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldSiglaUnidadeDeMedida.setBackground(Color.yellow);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldSiglaUnidadeDeMedida.setBackground(Color.ORANGE);
            }
        });

        textFieldQuantidade_produto.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldQuantidade_produto.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldQuantidade_produto.setBackground(Color.white);
            }
        });

        textFieldPreco_unitario.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldPreco_unitario.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldPreco_unitario.setBackground(Color.white);
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);//faz a janela ficar visível
        textFieldId.requestFocus();

    } //fim do construtor 

}//fim
