/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosGridBagLayout;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Radames
 */
public class TesteGridBagLayout1 extends JFrame {

    public TesteGridBagLayout1() {
        super("Exemplo1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = this.getContentPane();

        GridBagConstraints cons = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        c.setLayout(layout);

        //mod 01
        cons.ipadx = 200;
        cons.ipady = 40;

        //mod 02
//        cons.insets = new Insets(10, 10, 10, 10);

        //mod 03
//        cons.weightx = 1;
//        cons.weighty = 1;

        //mod 04
//        cons.anchor = GridBagConstraints.SOUTHEAST;
//        cons.anchor = GridBagConstraints.NORTH;
//        cons.anchor = GridBagConstraints.SOUTH;
//        cons.anchor = GridBagConstraints.WEST;
//        cons.anchor = GridBagConstraints.EAST;

        //mod05
        //   cons.fill = GridBagConstraints.HORIZONTAL;



        c.add(new JButton("Esquerda ...."), cons);
        c.add(new JButton("Direita"), cons);

        this.setSize(600, 600);
    }

    public static void main(String[] args) {
        TesteGridBagLayout1 exe = new TesteGridBagLayout1();
        exe.setVisible(true);
    }
}
