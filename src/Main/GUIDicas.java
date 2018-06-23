

package Main;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GUIDicas extends JDialog {
    private JTextArea ta = new JTextArea();
    private Container cp;
    
    public GUIDicas() {
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(1,1));
        setTitle("Dicas");
        
        cp.add(ta);
        
        ta.append("Você pressionou F1 no jFrame principal (GUI)\n");
        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
    }
}
