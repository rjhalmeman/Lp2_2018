package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

    private Container cp;    
    
    private JPanel pn1 = new JPanel();
    private JPanel pn2 = new JPanel();
    private JPanel pn3 = new JPanel();
    private JPanel pn4 = new JPanel();
    private JPanel pn5 = new JPanel();
    private JPanel pn6 = new JPanel();
    private JPanel pn7 = new JPanel();
    private JPanel pn8 = new JPanel();
    private JPanel pn9 = new JPanel();
    
    private JPanel pn1_1 = new JPanel();
    private JPanel pn1_2 = new JPanel();
    private JPanel pn1_3 = new JPanel();
    
    private JPanel pn2_1 = new JPanel();
    private JPanel pn2_2 = new JPanel();
    private JPanel pn2_3 = new JPanel();
    private JPanel pn2_4 = new JPanel();
    private JPanel pn2_5 = new JPanel();
    private JLabel lbAmostra = new JLabel();
    private JLabel lbAmostraN1 = new JLabel();
    private JLabel lbAmostraN2 = new JLabel();
    private JLabel lbAmostraN3 = new JLabel();
    private JLabel lbAmostraT = new JLabel();   
        
    private JPanel pn3_1 = new JPanel();
    private JPanel pn3_2 = new JPanel();
    private JPanel pn3_3 = new JPanel();
    
    private JPanel pn5_1 = new JPanel();
    private JPanel pn5_2 = new JPanel();
    private JPanel pn5_3 = new JPanel();
    
    private JPanel pn9_1 = new JPanel();
    private JPanel pn9_2 = new JPanel();
    private JPanel pn9_3 = new JPanel();

    private JLabel lb1 = new JLabel("Nota 1");
    private JTextField tf1 = new JTextField(9);
    
    private JLabel lb2 = new JLabel("Nota 2");
    private JTextField tf2 = new JTextField(9);

    private JLabel lb3 = new JLabel("Nota 3");
    private JTextField tf3 = new JTextField(9);

    private JLabel lb4 = new JLabel("Trabalhos");
    private JTextField tf4 = new JTextField(9);

    private JButton btCalc = new JButton("Calcular");
    
    private JLabel lb5 = new JLabel("    Média");
    private JTextField tf5 = new JTextField(9);

    private JLabel lb6 = new JLabel("Conceito");
    private JTextField tf6 = new JTextField(9);
    
    private JLabel lbV = new JLabel(" ");
   
    public GUI() {
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(3,3));
        setTitle("Avaliador de alunos");
        
        cp.add(pn1);        
        pn1.setLayout(new GridLayout(3,1));        
        pn1.add(pn1_1, BorderLayout.CENTER);
        pn1.add(pn1_2, BorderLayout.CENTER);
        pn1.add(pn1_3, BorderLayout.CENTER);
        
        pn1_1.add(lb1);
        pn1_1.add(tf1);
        pn1_2.add(lb2);
        pn1_2.add(tf2);
        pn1_3.add(lb3);
        pn1_3.add(tf3);
        
        cp.add(pn2);
        pn2.setLayout(new GridLayout(5,1));
        pn2.add(pn2_1, BorderLayout.CENTER);
        pn2.add(pn2_2, BorderLayout.CENTER);
        pn2.add(pn2_3, BorderLayout.CENTER);
        pn2.add(pn2_4, BorderLayout.CENTER);
        pn2.add(pn2_5, BorderLayout.CENTER);
        pn2_1.add(lbAmostra);
        pn2_2.add(lbAmostraN1);
        pn2_3.add(lbAmostraN2);
        pn2_4.add(lbAmostraN3);
        pn2_5.add(lbAmostraT);
        lbAmostra.setForeground(Color.DARK_GRAY);
        lbAmostraN1.setForeground(Color.red);
        lbAmostraN2.setForeground(Color.red);
        lbAmostraN3.setForeground(Color.red);
        lbAmostraT.setForeground(Color.red);
                       
        cp.add(pn3);
        pn3.setLayout(new GridLayout(3,1));
        pn3.add(pn3_1, BorderLayout.CENTER);
        pn3.add(pn3_2, BorderLayout.CENTER);
        pn3.add(pn3_3, BorderLayout.CENTER);
        pn3_1.add(lb4);
        pn3_1.add(tf4);
        pn3_2.add(lbV);
        pn3_2.add(lbV);
        pn3_3.add(lbV);
        pn3_3.add(lbV);
        
        cp.add(pn4);
        
        cp.add(pn5);
        pn5.setLayout(new GridLayout(3,1));
        pn5.add(pn5_1, BorderLayout.CENTER);
        pn5.add(pn5_2, BorderLayout.CENTER);
        pn5.add(pn5_3, BorderLayout.CENTER);
        pn5_1.add(lbV);
        pn5_2.add(btCalc);        
        pn5_3.add(lbV);        
        
        cp.add(pn6);
        
        cp.add(pn7);
        
        cp.add(pn8);
        
        cp.add(pn9);
        pn9.setLayout(new GridLayout(3,1));
        pn9.add(pn9_1, BorderLayout.CENTER);
        pn9.add(pn9_2, BorderLayout.CENTER);
        pn9.add(pn9_3, BorderLayout.CENTER);
        pn9_1.add(lb5);
        pn9_1.add(tf5);
        tf5.setEnabled(false);
        pn9_2.add(lb6);
        pn9_2.add(tf6);
        tf6.setEnabled(false);
        pn9_3.add(lbV);
        pn9_3.add(lbV);       
                
        btCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                
                Processamento proc = new Processamento();
                                    
                if (tf1.getText().equals("")) {
                    tf1.setText("0");
                }
                if (tf2.getText().equals("")) {
                    tf2.setText("0");
                }
                if (tf3.getText().equals("")) {
                    tf3.setText("0");
                }
                if (tf4.getText().equals("")) {
                    tf4.setText("0");
                }
                
                proc.setN1(Double.valueOf(tf1.getText()));
                proc.setN2(Double.valueOf(tf2.getText()));
                proc.setN3(Double.valueOf(tf3.getText()));                
                proc.setT(Double.valueOf(tf4.getText()));
                
                DecimalFormat df = new DecimalFormat("#0.00");
                tf5.setText(df.format(proc.getM()));
                tf5.setBackground(Color.darkGray);
                tf6.setText(proc.getC()); 
                tf6.setBackground(Color.darkGray);
                
                lbAmostra.setText("Informações");
                lbAmostraN1.setText("Nota 1: "+tf1.getText());
                lbAmostraN2.setText("Nota 2: "+tf2.getText());
                lbAmostraN3.setText("Nota 3: "+tf3.getText());
                lbAmostraT.setText("Nota T: "+tf4.getText());
                
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                
                tf1.requestFocus();
                
            }
        });   
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
