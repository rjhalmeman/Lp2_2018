package Main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {
    
    private Container cp;
    private JLabel meuLabel = new JLabel("Meu label");
    private JTextField meuTextField = new JTextField(20);
    String aux="";
    
    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Teste");
        
        cp.add(meuLabel,BorderLayout.NORTH);
        cp.add(meuTextField,BorderLayout.CENTER);
        
        aux = meuLabel.getText();//para não perder o valor original do Label
        
        meuTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
              meuLabel.setText(aux+" ["+meuTextField.getText()+"]");
            }
        });
        
        
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
