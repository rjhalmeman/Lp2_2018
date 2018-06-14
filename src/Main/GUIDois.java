package Main;

// @author Radames
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIDois extends JDialog {

    private String valorTransferido;

    JButton btnCancelar = new JButton("Cancelar");
    JButton btnOK = new JButton("Ok");

    public GUIDois(String valorTransferido) {//esse construtor é importante para receber dados 
        this.valorTransferido = valorTransferido; //da janela que chama
    }

    public String getValorTransferido() {
        Inicialize();
        setVisible(true);
        return valorTransferido;
    }

    public void finalizeJanela() {
        dispose();
    }

    public void Inicialize() {
        setTitle("Janela Dois");
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.yellow);

        panel.add(new JLabel("A JanelaUm enviou [" + valorTransferido + "]  digite algo para retornar"));
        final JTextField textFieldValor = new JTextField(30);
        panel.add(textFieldValor);

        panel.add(btnCancelar);
        panel.add(btnOK);

        Container container = getContentPane();
        container.add(panel);
        setModal(true);

        setLocationRelativeTo(null);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valorTransferido = textFieldValor.getText(); //atribui o valor para que seja retornado
                dispose(); //fecha a janela (voltara para a janelaUm que chamou)
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valorTransferido = null; //atribui NULL para que seja retornado
                dispose(); //fecha a janela (voltara para a janelaUm que chamou)
            }
        });
    }
}
