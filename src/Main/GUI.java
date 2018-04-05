package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {

    private Container cp;
    private JLabel lbA = new JLabel("Rótulo A");
    private JTextField tfA = new JTextField(5);

    private JButton btCalcular = new JButton("Calcular");

    private JLabel lbResp = new JLabel("Resp");

    private JTextField tfResp = new JTextField(5);

    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(7, 2));
        setTitle("Básico");

        cp.add(lbA);
        cp.add(tfA);

        cp.add(btCalcular);
        cp.add(new JLabel(""));
        cp.add(lbResp);
        cp.add(tfResp);

        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Processamento mp = new Processamento();
                //enviar dados
                mp.setValor(Double.valueOf(tfA.getText()));

                //obter resposta
                tfResp.setText(String.valueOf(mp.getResposta()));

            }
        });

        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
