package exemploswing01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrame1 extends JFrame {

    public JFrame1() {
        super();
        // setSize(300, 200);
        setTitle("Imagens...");
        JPanel p1 = new JPanel(new GridLayout());
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
         
        p4.setBackground(Color.yellow);
        p5.setBackground(Color.blue);
        
        JLabel imagem1 = new JLabel();
        JLabel imagem2 = new JLabel();
        JLabel imagem3 = new JLabel();
        JLabel imagem4 = new JLabel();
        JLabel imagem5 = new JLabel();
        
        imagem1.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/Figuras/xicara_java.gif")));
        imagem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figuras/gorila_02.gif")));
        imagem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figuras/java_xicara_02.gif")));
        imagem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figuras/gato_mexendo_rabo_5.gif")));
        imagem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figuras/patera_correndo_03.gif")));

        p1.add(imagem3);
        p1.add(imagem4);
        p2.add(imagem2);
        p3.setLayout(new GridLayout(1,3,10,0));
        p3.add(imagem1);
        p3.add(imagem5);
        p3.add(imagem3);
         

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        add(p4, BorderLayout.WEST);
        add(p5, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocation(100,100);
    }
}
