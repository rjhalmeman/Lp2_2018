/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author radames
 */
class GUI extends JFrame {

    private Container cp;
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(2, 2));
    private JPanel pnSul = new JPanel();

    private JLabel lbChave = new JLabel("Id");
    private JLabel lbNome = new JLabel("Nome");
    private JLabel lbEndereco = new JLabel("Endereço");

    private JTextField tfChave = new JTextField(5);
    private JTextField tfNome = new JTextField(30);
    private JTextField tfEndereco = new JTextField(30);

    private JButton btBuscar = new JButton("Buscar");
    private JButton btAdicionar = new JButton("INS");
    private JButton btAlterar = new JButton("UPD");
    private JButton btExcluir = new JButton("DEL");
    
    
    public GUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.add(lbChave);
        pnNorte.add(tfChave);
        pnNorte.add(btBuscar);
        pnNorte.add(btAdicionar);
        pnNorte.add(btAlterar);
        pnNorte.add(btExcluir);
        
        pnCentro.add(lbNome);
        pnCentro.add(tfNome);
        pnCentro.add(lbEndereco);
        pnCentro.add(tfEndereco);
        
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controle controle = new Controle();
                Contato contato = controle.buscar(tfChave.getText());
                if (contato==null) { //nao achou
                    btAdicionar.setVisible(true);
                    btAlterar.setVisible(false);
                    btExcluir.setVisible(false);
                }

            }
        });
        
        
        
        setSize(700, 150);
        setTitle("Crud contatos");
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
