package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author radames
 */
class GUI extends JFrame {

    private Container cp;
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(2, 2));
    private JPanel pnSul = new JPanel();

    private JLabel lbChave = new JLabel("Id");
    private JLabel lbNome = new JLabel("Nome");
    private JLabel lbEndereco = new JLabel("Endereço");

    private JTextField tfChave = new JTextField(5);
    private JTextField tfNome = new JTextField(30);
    private JTextField tfEndereco = new JTextField(30);

    private JButton btBuscar = new JButton("Buscar");
    private JButton btInserir = new JButton("INS");
    private JButton btAlterar = new JButton("UPD");
    private JButton btExcluir = new JButton("DEL");
    private JButton btSalvar = new JButton("Salvar");
    private JButton btCancelar = new JButton("Cancelar");
    private boolean inserindo;
    Controle controle = new Controle();
    Contato contato = new Contato();

    public GUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.add(lbChave);
        pnNorte.add(tfChave);
        pnNorte.add(btBuscar);
        pnNorte.add(btInserir);
        pnNorte.add(btAlterar);
        pnNorte.add(btExcluir);
        pnNorte.add(btSalvar);
        pnNorte.add(btCancelar);

        pnCentro.add(lbNome);
        pnCentro.add(tfNome);
        pnCentro.add(lbEndereco);
        pnCentro.add(tfEndereco);

        btSalvar.setVisible(false);
        btCancelar.setVisible(false);
        btInserir.setVisible(false);
        btAlterar.setVisible(false);
        btExcluir.setVisible(false);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contato = controle.buscar(tfChave.getText());
                if (contato == null) { //nao achou
                    btInserir.setVisible(true);
                    btAlterar.setVisible(false);
                    btExcluir.setVisible(false);
                } else { //achou
                    btAlterar.setVisible(true);
                    btExcluir.setVisible(true);
                    tfChave.setText(contato.getId());
                    tfNome.setText(contato.getNome());
                    tfEndereco.setText(contato.getEndereco());
                }

            }
        });

        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                inserindo = false;
            }
        });

        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNome.requestFocus();
                btInserir.setVisible(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                inserindo = true;
            }
        });

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contato contatoOriginal = contato;

                contato.setId(tfChave.getText());
                contato.setNome(tfNome.getText());
                contato.setEndereco(tfEndereco.getText());

                if (inserindo) {
                    contato = new Contato();
                    contato.setId(tfChave.getText());
                    controle.inserir(contato);
                } else {//alterar
                    System.out.println("contato original "
                            + contatoOriginal.toString());
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

        setSize(700, 150);
        setTitle("Crud contatos");
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
