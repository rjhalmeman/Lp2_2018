package Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author radames
 */
class GUI extends JFrame {

    private Container cp;
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(2, 2));
    private CardLayout cardLayout = new CardLayout();
    private JPanel pnSul = new JPanel(cardLayout);
    private JPanel pnSulMsg = new JPanel(new GridLayout(1, 1));
    private JPanel pnSulListagem = new JPanel(new GridLayout(1, 1));

    private JLabel lbId = new JLabel("Id");
    private JLabel lbNome = new JLabel("Nome");
    private JLabel lbEndereco = new JLabel("Endereço");

    private JTextField tfChave = new JTextField(5);
    private JTextField tfNome = new JTextField(30);
    private JTextField tfEndereco = new JTextField(30);

    private JButton btBuscar = new JButton("Buscar");
    private JButton btInserir = new JButton("Inserir");
    private JButton btAlterar = new JButton("Alterar");
    private JButton btExcluir = new JButton("Excluir");
    private JButton btListar = new JButton("Listar");
    private JButton btSalvar = new JButton("Salvar");
    private JButton btCancelar = new JButton("Cancelar");

    String[] colunas = new String[]{"Id", "Nome", "Endereço"};
    String[][] dados = new String[0][3];

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);
//                scrollList.add(tabela);
    JScrollPane scrollList = new JScrollPane();

    private ScrollPane scrollMensagem = new ScrollPane();

    JTextArea textAreaMsg = new JTextArea();

    private boolean inserindo; //esta variável controla se é uma operação de INSERT ou UPDATE no botão salvar

    private Controle controle = new Controle(); //essa é a classe de processamento (controle da lista de contatos)
    private Contato contato = new Contato(); //ver classe contato

    private void setLog(String msg) {

        textAreaMsg.requestFocus();
        textAreaMsg.setCaretPosition(textAreaMsg.getDocument().getLength());
        textAreaMsg.append(msg + "\n");
    }

    private void travarTextFields(boolean campo) {
        tfChave.setEditable(campo);
        tfNome.setEditable(!campo);
        tfEndereco.setEditable(!campo);
    }

    public GUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.add(lbId);
        pnNorte.add(tfChave);
        pnNorte.add(btBuscar);
        pnNorte.add(btInserir);
        pnNorte.add(btAlterar);
        pnNorte.add(btExcluir);
        pnNorte.add(btSalvar);
        pnNorte.add(btCancelar);
        pnNorte.add(btListar);

        pnCentro.add(lbNome);
        pnCentro.add(tfNome);
        pnCentro.add(lbEndereco);
        pnCentro.add(tfEndereco);

        scrollMensagem.add(textAreaMsg);

        pnSul.add(pnSulMsg, "pnMsg");
        pnSul.add(pnSulListagem, "pnLst");

        pnSulMsg.add(scrollMensagem);

        pnSul.setBackground(Color.red);

        btSalvar.setVisible(false);
        btCancelar.setVisible(false);
        btInserir.setVisible(false);
        btAlterar.setVisible(false);
        btExcluir.setVisible(false);
        
        travarTextFields(true);

// ------------------------BOTAO BUSCAR ----------------------------------------        
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                travarTextFields(true);
                cardLayout.show(pnSul, "pnMsg");
                contato = controle.buscar(tfChave.getText());
                if (contato == null) { //nao achou
                    btInserir.setVisible(true);
                    btAlterar.setVisible(false);
                    btExcluir.setVisible(false);
                    setLog("Não achou na lista, pode inserir se quiser...");
                } else { //achou
                    btAlterar.setVisible(true);
                    btExcluir.setVisible(true);
                    tfChave.setText(contato.getId());
                    tfNome.setText(contato.getNome());
                    tfEndereco.setText(contato.getEndereco());
                    setLog("Achou na lista, pode alterar ou excluir...");
                }
            }

        });

//*********************** BOTÃO SALVAR ****************************************        
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contato contatoOriginal = contato; //para pesquisar na lista
                //precisamos do contato original (para depois modificar)

                contato.setId(tfChave.getText());
                contato.setNome(tfNome.getText());
                contato.setEndereco(tfEndereco.getText());

                if (inserindo) { //a variavel inserindo é preenchida nos  
                    //listenners dos botões alterar ou excluir
                    contato = new Contato(); //criar um novo contato                   
                    controle.inserir(contato);
                } else {//alterar                  
                    controle.alterar(contatoOriginal, contato);
                }

                //voltar para tela inicial
                tfChave.requestFocus();
                tfChave.selectAll();
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                tfNome.setText("");
                tfEndereco.setText("");

            }
        });
//############################# BOTAO ALTERAR #################################
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                inserindo = false;
                travarTextFields(false);
            }
        });
//||||||||||||||||||||||||||| BOTÃO INSERIR |||||||||||||||||||||||||||||||||||
        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNome.requestFocus();
                btInserir.setVisible(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                inserindo = true;
                travarTextFields(false);
            }
        });

//======================= LISTAR =============================================
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnSul, "pnLst");
                scrollList.setPreferredSize(tabela.getPreferredSize());
                pnSulListagem.add(scrollList);
                scrollList.setViewportView(tabela);
                List<String> listaDeContatos = controle.listar();//busca a lista de contatos
                String[] aux;
                colunas = new String[]{"Id", "Nome", "Endereço"};
                dados = new String[0][3];
                model.setDataVector(dados, colunas);
                for (int i = 0; i < listaDeContatos.size(); i++) {
                    aux = listaDeContatos.get(i).split(";");
                    String[] linha = new String[]{aux[0], aux[1], aux[2]};
                    // String[] linha = new String[]{"João", "15", "Masculino"};
                    model.addRow(linha);
                }

            }
        });

// parâmetros para janela inicial
        setSize(700, 200);
        setTitle("Crud contatos");
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
