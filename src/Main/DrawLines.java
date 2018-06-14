package Main;

//http://www.javaprogressivo.net/2012/11/O-que-sao-e-como-usar-os-metodos-getWidth-e-getHeight.html
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawLines extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), 0);
       
    }
}
