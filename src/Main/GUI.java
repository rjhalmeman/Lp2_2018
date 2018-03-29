

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
    private JLabel lbAnoNasc = new JLabel("Ano Nascimento");
    private JLabel lbIdade = new JLabel("Idade");
    private JLabel lbPode = new JLabel("Pode");
    
    private JButton btCalcular = new JButton("Calcular");
    
    private JTextField tfAno = new JTextField(5);
    private JTextField tfIdade = new JTextField(5);
    private JTextField tfPode = new JTextField(5);
    
    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(4,2));
        setTitle("Exercicio 3 - lista 1");
        
        cp.add(lbAnoNasc);
        cp.add(tfAno);
        cp.add(btCalcular);
        cp.add(new JLabel("vazio"));
        cp.add(lbIdade);
        cp.add(tfIdade);
        cp.add(lbPode);
        cp.add(tfPode);
        
        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Calcular calcular = new Calcular(); 
                 calcular.setAnoNasc(Integer.valueOf(tfAno.getText()));
                 
                 tfIdade.setText(String.valueOf(calcular.getIdade()));
                 tfPode.setText(calcular.getPodeOQue());
                 
            }
        });
        
        
        
        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
