package Main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DateTextField_GUI extends JFrame {

    Container cp;
    DateTextField dateTextField1 = new DateTextField();
    DateTextField dateTextField2 = new DateTextField();
    JLabel jLabel = new JLabel();
    JButton btVai = new JButton("getData");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public DateTextField_GUI() {
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new FlowLayout());
        setTitle("DateTextField");
        setLocationRelativeTo(null);
        cp.add(new JLabel("Clic na Data  ===> "));

        cp.add(dateTextField1);
        cp.add(new JLabel("  Natal===> "));
        cp.add(dateTextField2);

        cp.add(btVai);
        cp.add(jLabel);
        dateTextField2.setText("25/12/2015");

        btVai.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setText("A data escolhida foi: " 
                        + simpleDateFormat.format(dateTextField1.getDate()));
                
            }
        });

        
        setVisible(true);
    }

}
