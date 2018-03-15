

package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class GUI extends JFrame {
    
    private Container cp;
    
    public GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("GUI");
        
        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }
}
