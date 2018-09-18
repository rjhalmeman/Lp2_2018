package Main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame {

    private Container cp;
    private JPanel painelSpinners = new JPanel();
    private JPanel painelResp = new JPanel(new FlowLayout(FlowLayout.CENTER));

    private JLabel labelTempo = new JLabel();
    private SpinnerDateModel dateModel = new SpinnerDateModel();
    private JSpinner spinner = new JSpinner(dateModel);
    private JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "HH:mm:ss");

    public GUI() {

        spinner.setEditor(timeEditor);
        Time time = new Time(dateModel.getDate().getTime());

        setSize(200, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(2, 1));
        setTitle("Spinner Time");

        cp.add(painelSpinners);
        cp.add(painelResp);
        painelSpinners.add(spinner);
        painelResp.add(labelTempo);

        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Date date = (Date) ((JSpinner) e.getSource()).getValue();
                labelTempo.setText(new SimpleDateFormat("HH:mm:ss").format(date));
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }
}
