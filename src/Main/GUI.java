

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
    private JLabel lbAluno = new JLabel("Código do aluno");
    private JTextField tfAluno = new JTextField(5);
    
    private JLabel lbNota1 = new JLabel("Nota 1");
    private JLabel lbNota2 = new JLabel("Nota 2");
    private JLabel lbNota3 = new JLabel("Nota 3");
    
    private JTextField tfNota1 = new JTextField(5);
    private JTextField tfNota2 = new JTextField(5);
    private JTextField tfNota3 = new JTextField(5);
    
    private JButton btCalcular = new JButton("Calcular");
    
    private JLabel lbMedia = new JLabel("Média");
    private JLabel lbSituacao = new JLabel("Situação");
    
    private JTextField tfMedia = new JTextField(5);
    private JTextField tfSituacao = new JTextField(5);
   
    
    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(7,2));
        setTitle("Exercício 05");
        
        cp.add(lbAluno);
        cp.add(tfAluno);
        cp.add(lbNota1);
        cp.add(tfNota1);
        cp.add(lbNota2);
        cp.add(tfNota2);
        cp.add(lbNota3);
        cp.add(tfNota3);
        cp.add(btCalcular);
        cp.add(new JLabel(""));
        cp.add(lbMedia);
        cp.add(tfMedia);
        cp.add(lbSituacao);
        cp.add(tfSituacao);
        
        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediaPonderada mp = new MediaPonderada();
                //enviar dados
                mp.setNota1(Double.valueOf(tfNota1.getText()));
                mp.setNota2(Double.valueOf(tfNota2.getText()));
                mp.setNota3(Double.valueOf(tfNota3.getText()));
                
                //obter resposta
                tfMedia.setText(String.valueOf(mp.getMedia()));
                tfSituacao.setText(mp.getSituacao());
                
            }
        });
        
        
        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
