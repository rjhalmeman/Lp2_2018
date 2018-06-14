package Main;

// @author Radames
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUm {

    public GUIUm() {

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);
        frame.setTitle("Janela Um");
        JPanel painelCampos = new JPanel();

        painelCampos.setLayout(new GridLayout(2, 2));
        painelCampos.setBackground(Color.GREEN);

        painelCampos.add(new JLabel("Texto enviado "));
        final JTextField tfTextoEnviado = new JTextField(20);
        painelCampos.add(tfTextoEnviado);

        final JTextField tfTextoRecebido = new JTextField(20);

        painelCampos.add(new JLabel("Texto recebido "));
        painelCampos.add(tfTextoRecebido);

        JPanel painelBotao = new JPanel();
        JButton btnOK = new JButton("Chamar outra janela (JDialog)");

        painelBotao.add(btnOK);

        Container painelPrincipal = frame.getContentPane();
        painelPrincipal.setLayout(new GridLayout(2, 1));
        painelPrincipal.add(painelCampos);
        painelPrincipal.add(painelBotao);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //vai enviar para a janelaDois o texto que estiver no tfTextoEnviado da GUIUm                 
                //ao retornar, coloca em tfTextoRecebido o texto que foi digitado na GUIDois (JDialog)
                GUIDois j2 = new GUIDois(tfTextoEnviado.getText());//envia os dados
                tfTextoRecebido.setText(j2.getValorTransferido());

            }
        });

    }
}
