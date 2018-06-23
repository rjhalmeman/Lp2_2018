package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI extends JFrame {

    //para detectar qual tecla foi pressionada
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    new GUIDicas();
                }
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                //System.out.println("2test2");
            } else if (e.getID() == KeyEvent.KEY_TYPED) {
                // System.out.println("3test3");
            }
            return false;
        }
    }

    private Container cp;
    private JLabel jLabel = new JLabel("Pressione a Tecla F1 para abrir outra janela");
    private JTextField jTextField = new JTextField(20);
    private JButton jButton = new JButton("botão");

    public GUI() {

        //para instanciar a classe das teclas
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

        
        
        
        
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(3, 1));
        setTitle("Principal");

        cp.add(jLabel);
        cp.add(jTextField);
        cp.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(cp, "apertou o botão");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
