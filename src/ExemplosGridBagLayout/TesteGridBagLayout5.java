/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosGridBagLayout;

import java.awt.*;  
import javax.swing.*;  
  
public class TesteGridBagLayout5 extends JFrame {  
  
    public TesteGridBagLayout5() {  
        super("Exemplo5");  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
          
        this.getContentPane().setLayout(new GridBagLayout());  
         
        add("Código", new JTextField(), "Nascimento", new JTextField());  
        add("Nome", new JTextField());  
        add("Nome Pai", new JTextField());  
        add("Nome Mãe", new JTextField());  
        add("RG", new JTextField(), "CPF", new JTextField());  
        add("Endereços", new JScrollPane(new JTable()));  
        
        this.setSize(600,600); 
        this.setLocationRelativeTo(null); 
    }  
  
    /** 
     * Adiciona um label e um componente horizontalmente 
     * @param label String que irá aparecer no label 
     * @param componente Componente de edição 
     */  
    public void add(String label, JComponent componente ) {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.NONE;  //não "esticar"
        cons.anchor = GridBagConstraints.NORTHWEST; //canto superior esquerdo 
        cons.insets = new Insets(4,4,4,4);  //distancia entre os componentes
  
        cons.weightx = 0;  
        cons.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), cons);  
          
        cons.fill = GridBagConstraints.BOTH;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente, cons);  
    }  
      
  
    /** 
     * Adiciona um label e um componente horizontalmente. 
     * O componente ocupará todo o resto da tela 
     * @param label String que irá aparecer no label 
     * @param componente Componente de edição 
     */  
    public void add(String label, JScrollPane componente ) {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.NONE;  
        cons.anchor = GridBagConstraints.NORTHWEST;  
        cons.insets = new Insets(4,4,4,4);  
        cons.weighty = 1;  
        cons.gridheight = GridBagConstraints.REMAINDER;  
          
        cons.weightx = 0;  
        cons.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), cons);  
          
        cons.fill = GridBagConstraints.BOTH;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente, cons);  
    }      
      
    /** 
     * Adiciona um label, um componente de edição, mais um label e outro componente de edição. Todos  
     * na mesma linha 
     * @param label Label 1  
     * @param componente Componente de edição 
     * @param label2 Label 2 
     * @param componente2 Componente de edição 2 
     */  
    public void add(String label, JComponent componente, String label2, JComponent componente2) {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.BOTH;  
        cons.insets = new Insets(4,4,4,4);  
  
        cons.fill = GridBagConstraints.NONE;  
        cons.anchor = GridBagConstraints.NORTHWEST;  
        cons.weightx = 0;  
        cons.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), cons);  
          
        cons.weightx = 1;  
        cons.gridwidth = 1;  
        cons.fill = GridBagConstraints.BOTH;  
        this.getContentPane().add(componente, cons);  
  
        cons.fill = GridBagConstraints.NONE;  
        cons.weightx = 0;  
        cons.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label2), cons);  
          
        cons.weightx = 1;  
        cons.fill = GridBagConstraints.BOTH;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente2, cons);  
    }      
      
    public static void main(String[] args ) {  
        TesteGridBagLayout5 exe = new TesteGridBagLayout5();  
        exe.setVisible(true);        
    }  
}  

