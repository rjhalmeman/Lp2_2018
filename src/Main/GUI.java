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

public class GUI extends JFrame {

    private Container cp;

    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();

    private JLabel lbTitulo = new JLabel("Lanches Nerd");

    private JButton btCalcular = new JButton("Calcular");

    private JLabel lbQuantidade = new JLabel("Quantidade");
    private JLabel lbLanche = new JLabel("Lanche");
    private JLabel lbPreco = new JLabel("Preço");
    private JLabel lbSubtotal = new JLabel("Subtotal");

    private JTextField tfQuantidadeXSalada = new JTextField(5);
    private JLabel lbXsalada = new JLabel("X-Salada");
    private JLabel lbPrecoXsalada = new JLabel("12,00");
    private JLabel lbSubTotalXsalada = new JLabel("0,00");

    private JTextField tfResp = new JTextField(5);

    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        setTitle("Exercício 1 - Lista 2");

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);

        pnNorte.setBackground(Color.cyan);
        pnNorte.add(lbTitulo);
        pnNorte.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnCentro.setLayout(new GridLayout(1, 4));

        pnCentro.add(lbQuantidade);
        pnCentro.add(lbLanche);
        pnCentro.add(lbPreco);
        pnCentro.add(lbSubtotal);

        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Processamento mp = new Processamento();
                //enviar dados
      //          mp.setValor(Double.valueOf(tfA.getText()));

                //obter resposta
                tfResp.setText(String.valueOf(mp.getResposta()));

            }
        });

        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
