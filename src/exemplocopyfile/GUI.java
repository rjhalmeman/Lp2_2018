package exemplocopyfile;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author radames
 */
public class GUI extends JFrame {

    JLabel lbOrigem = new JLabel("Origem");
    JLabel lbDestino = new JLabel("Destino");
    JTextField tfOrigem = new JTextField(50);
    JTextField tfDestino = new JTextField(50);
    JPanel pnOrigem;
    JPanel pnDestino;
    JPanel pnCentro = new JPanel();
    JPanel pnNorte = new JPanel();
    JPanel pnSul = new JPanel();
    JTextArea taLista = new JTextArea();
    JButton btnCopie = new JButton("Copie");
    JButton btnListe = new JButton("Liste");
    Container containerPrincipal;

    public GUI() {
        //as linhas 38 e 39 são apenas para facilitar os testes e deverão ser removidas após a conclusão do programa
        tfOrigem.setText("/home/radames/aa/doc1.txt");
        tfDestino.setText("/home/radames/bb/docB.txt");

        setSize(800, 150);
        setTitle("Copiar arquivo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        containerPrincipal = getContentPane();

        pnOrigem = new JPanel();
        pnOrigem.add(lbOrigem);
        pnOrigem.add(tfOrigem);

        pnDestino = new JPanel();
        pnDestino.add(lbDestino);
        pnDestino.add(tfDestino);

        pnCentro.add(pnOrigem);
        pnCentro.add(pnDestino);

        pnNorte.add(btnCopie);
        pnNorte.add(btnListe);
        
        pnSul.add(taLista);
        pnSul.setLayout(new GridLayout(1,1));
        
        containerPrincipal.add(pnCentro, BorderLayout.CENTER);
        containerPrincipal.add(pnNorte, BorderLayout.NORTH);
        containerPrincipal.add(pnSul, BorderLayout.SOUTH);
        
        setLocationRelativeTo(this);//centraliza
        setVisible(true);

        btnCopie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JoaoArquivo joao = new JoaoArquivo();
                joao.copiar(tfOrigem.getText(), tfDestino.getText());
            }
        });

        btnListe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaArquivos = new ArrayList<String>();
                JoaoArquivo joao = new JoaoArquivo();
                taLista.setText("");
                listaArquivos = joao.qualOConteudoDaPasta(tfOrigem.getText());
                for (int i = 0; i < listaArquivos.size(); i++) {
                    taLista.append(listaArquivos.get(i)+"\n");
                }
            }
        });


    }
}
