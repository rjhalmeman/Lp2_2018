

package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.awt.BorderLayout;
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

public class GUI extends JFrame {
    
    private Container cp;
    private JPanel painelNorte = new JPanel();
    private JPanel painelCentro = new JPanel();
    private JPanel painelSul = new JPanel();
    private JLabel labelAvisoNorte = new JLabel("Média de uma disciplina");
    
    private JPanel painelCentroLinha1 = new JPanel();
    private JPanel painelCentroLinha2 = new JPanel();
    private JPanel painelCentroLinha3 = new JPanel();
    
    private JLabel labelNotas = new JLabel("Notas");
    private JTextField textFieldN1 = new JTextField(5);
    private JTextField textFieldN2 = new JTextField(5);
    private JTextField textFieldN3 = new JTextField(5);
    private JTextField textFieldN4 = new JTextField(5);
    
    private JButton buttonCalcular = new JButton("Calcular");
    
    private JLabel labelMedia = new JLabel("Média");
    private JTextField textFieldMedia = new JTextField(5);
    
    public GUI() {
        setSize(500, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Exercício proposto");
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelCentro, BorderLayout.CENTER);
        cp.add(painelSul,BorderLayout.SOUTH);
        
        painelCentro.setBackground(Color.cyan);
        painelNorte.add(labelAvisoNorte);
        
        painelCentro.setLayout(new GridLayout(3,1));
        
        painelCentro.add(painelCentroLinha1);
        painelCentro.add(painelCentroLinha2);
        painelCentro.add(painelCentroLinha3);
        painelCentroLinha1.setBackground(Color.green);
        painelCentroLinha2.setBackground(Color.yellow);
        painelCentroLinha3.setBackground(Color.blue);
        
        painelCentroLinha1.add(labelNotas);
        painelCentroLinha1.add(textFieldN1);
        painelCentroLinha1.add(textFieldN2);
        painelCentroLinha1.add(textFieldN3);
        painelCentroLinha1.add(textFieldN4);
        
        painelCentroLinha2.add(buttonCalcular);
        
        painelCentroLinha3.add(labelMedia);
        painelCentroLinha3.add(textFieldMedia);
        
        
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entidade entidade = new Entidade();
                entidade.setN1(Double.valueOf(textFieldN1.getText()));
                entidade.setN2(Double.valueOf(textFieldN2.getText()));
                entidade.setN3(Double.valueOf(textFieldN3.getText()));
                entidade.setN4(Double.valueOf(textFieldN4.getText()));
                
                textFieldMedia.setText(String.valueOf(entidade.getMedia()));
                
            }
        });
        
        
        
        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
