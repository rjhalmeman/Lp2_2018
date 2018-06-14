package Main;

//http://www.javaprogressivo.net/2012/11/O-que-sao-e-como-usar-os-metodos-getWidth-e-getHeight.html
import javax.swing.JFrame;

public class GUI extends JFrame {

    public GUI() {
        setTitle("DrawLines e getWidth");
        DrawLines panel = new DrawLines();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setVisible(true);
        add(panel);
        setLocationRelativeTo(null);
        System.out.println("x "+getLocation());
    }

}
