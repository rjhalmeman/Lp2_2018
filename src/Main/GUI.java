package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.SwingConstants;

public class GUI extends JFrame {

    private Container cp;

    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();
    JPanel pnSul = new JPanel(new FlowLayout(FlowLayout.CENTER));

    private JLabel lbTitulo = new JLabel("Lanches Nerd");

    private JLabel lbQuantidade = new JLabel("Quantidade");
    private JLabel lbLanche = new JLabel("Lanche");
    private JLabel lbPreco = new JLabel("Preço");
    private JLabel lbSubtotal = new JLabel("Subtotal");

    private JTextField tfQuantidadeXSalada = new JTextField(5);
    private JLabel lbXSalada = new JLabel("X-Salada");
    private JLabel lbPrecoXSalada = new JLabel("12.00");
    private JLabel lbSubTotalXSalada = new JLabel("0,00");

    private JTextField tfQuantidadeXEgg = new JTextField(5);
    private JLabel lbXEgg = new JLabel("X-Egg");
    private JLabel lbPrecoXEgg = new JLabel("9.00");
    private JLabel lbSubTotalXEgg = new JLabel("0,00");

    private JTextField tfQuantidadeXFrango = new JTextField(5);
    private JLabel lbXFrango = new JLabel("X-Frango");
    private JLabel lbPrecoXFrango = new JLabel("11.00");
    private JLabel lbSubTotalXFrango = new JLabel("0,00");

    private JTextField tfQuantidadeXTudo = new JTextField(5);
    private JLabel lbXTudo = new JLabel("X-Tudo");
    private JLabel lbPrecoXTudo = new JLabel("17.00");
    private JLabel lbSubTotalXTudo = new JLabel("0,00");

    private JTextField tfQuantidadeXNerd = new JTextField(5);
    private JLabel lbXNerd = new JLabel("X-Nerd");
    private JLabel lbPrecoXNerd = new JLabel("15.33");
    private JLabel lbSubTotalXNerd = new JLabel("0,00");

    private JButton btCalcular = new JButton("Calcular");

    private JLabel lbTotal = new JLabel("Total");
    private JLabel lbTotalResp = new JLabel("0,00");

    private JLabel lbAviso = new JLabel("--");

    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        setTitle("Exercício 1 - Lista 2");

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.setBackground(Color.cyan);
        pnNorte.add(lbTitulo);
        pnNorte.setLayout(new FlowLayout(FlowLayout.CENTER));

        
        
        pnCentro.setLayout(new GridLayout(8, 4));

        pnCentro.add(lbQuantidade);
        
        pnCentro.add(lbLanche);
        pnCentro.add(lbPreco);
        pnCentro.add(lbSubtotal);

        pnCentro.add(tfQuantidadeXEgg);
        pnCentro.add(lbXEgg);
        pnCentro.add(lbPrecoXEgg);
        pnCentro.add(lbSubTotalXEgg);

        pnCentro.add(tfQuantidadeXEgg);
        pnCentro.add(lbXEgg);
        pnCentro.add(lbPrecoXEgg);
        pnCentro.add(lbSubTotalXEgg);

        pnCentro.add(tfQuantidadeXFrango);
        pnCentro.add(lbXFrango);
        pnCentro.add(lbPrecoXFrango);
        pnCentro.add(lbSubTotalXFrango);

        pnCentro.add(tfQuantidadeXTudo);
        pnCentro.add(lbXTudo);
        pnCentro.add(lbPrecoXTudo);
        pnCentro.add(lbSubTotalXTudo);

        pnCentro.add(tfQuantidadeXNerd);
        pnCentro.add(lbXNerd);
        pnCentro.add(lbPrecoXNerd);
        pnCentro.add(lbSubTotalXNerd);

        pnCentro.add(new JLabel(""));
        pnCentro.add(new JLabel(""));
        pnCentro.add(new JLabel(""));
        pnCentro.add(new JLabel(""));

        pnCentro.add(btCalcular);
        pnCentro.add(new JLabel(""));
        pnCentro.add(lbTotal);
        pnCentro.add(lbTotalResp);

        pnSul.add(lbAviso);

        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Processamento proc = new Processamento();
                try { // o try catch vai garantir que o usuário digite números válidos
                    
                    //entrada de dados
                    
                    //se estiver vazio, substitui por zero para evitar erros nas contas
                    if (tfQuantidadeXSalada.getText().equals("")) {
                        tfQuantidadeXSalada.setText("0");
                    }
                    if (tfQuantidadeXEgg.getText().equals("")) {
                        tfQuantidadeXEgg.setText("0");
                    }
                    if (tfQuantidadeXFrango.getText().equals("")) {
                        tfQuantidadeXFrango.setText("0");
                    }
                    if (tfQuantidadeXTudo.getText().equals("")) {
                        tfQuantidadeXTudo.setText("0");
                    }
                    if (tfQuantidadeXNerd.getText().equals("")) {
                        tfQuantidadeXNerd.setText("0");
                    }

                    proc.setPrecoXSalada(Double.valueOf(lbPrecoXSalada.getText()));
                    proc.setPrecoXEgg(Double.valueOf(lbPrecoXEgg.getText()));
                    proc.setPrecoXFrango(Double.valueOf(lbPrecoXFrango.getText()));
                    proc.setPrecoXTudo(Double.valueOf(lbPrecoXTudo.getText()));
                    proc.setPrecoXNerd(Double.valueOf(lbPrecoXNerd.getText()));

                    proc.setQtXSalada(Integer.valueOf(tfQuantidadeXSalada.getText()));
                    proc.setQtXEgg(Integer.valueOf(tfQuantidadeXEgg.getText()));
                    proc.setQtXFrango(Integer.valueOf(tfQuantidadeXFrango.getText()));
                    proc.setQtXTudo(Integer.valueOf(tfQuantidadeXTudo.getText()));
                    proc.setQtXNerd(Integer.valueOf(tfQuantidadeXNerd.getText()));

                    lbSubTotalXSalada.setText(String.valueOf(proc.getSubTotalXSalada()));
                    lbSubTotalXEgg.setText(String.valueOf(proc.getSubTotalXEgg()));
                    lbSubTotalXFrango.setText(String.valueOf(proc.getSubTotalXFrango()));
                    lbSubTotalXTudo.setText(String.valueOf(proc.getSubTotalXTudo()));
                    lbSubTotalXNerd.setText(String.valueOf(proc.getSubTotalXNerd()));

                    lbTotalResp.setText(String.valueOf(proc.getTotal()));
                } catch (Exception erro) {
                    lbAviso.setText("Erro nos dados >>> "+ erro.getMessage());
                }
            }
        });

        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
