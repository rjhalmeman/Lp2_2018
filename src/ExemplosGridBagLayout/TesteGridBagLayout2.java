package ExemplosGridBagLayout;

import java.awt.*;  
import javax.swing.*;  
  
public class TesteGridBagLayout2 extends JFrame {  
    public TesteGridBagLayout2() {  
        super("TesteGridBagLayout2");  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
          
        Container c = this.getContentPane();  
     
        GridBagConstraints cons = new GridBagConstraints();  
        GridBagLayout layout = new GridBagLayout();  
        c.setLayout(layout);  
         
        cons.fill = GridBagConstraints.BOTH;  
        cons.weighty = 1;  
          
        cons.weightx = 0.20;  
        c.add(new JButton("Esquerda"), cons);  
        cons.weightx = 0.80;  
        c.add(new JButton("Direita"), cons);  
              
        this.setSize(600,600);         
    }  
      
    public static void main(String[] args ) {  
        TesteGridBagLayout2 exe = new TesteGridBagLayout2();  
        exe.setVisible(true);     
    }  
} 


