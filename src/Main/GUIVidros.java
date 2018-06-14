package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import myUtil.CentroDoMonitorMaior;

/**
 *
 * @author radames
 */
public class GUIVidros extends JFrame {

    private Container cp;
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnNorteA = new JPanel(new GridLayout(3, 3));
    private JPanel pnNorteB = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(1, 1));
    private JPanel pnSul = new JPanel();
    private DefaultListModel modelo = new DefaultListModel();
    private JList jList = new JList(modelo);
    private Vidro vidro;
    private JButton btnDesenhar = new JButton("Desenhar");
    private JLabel lbX = new JLabel("Largura");
    private JLabel lbY = new JLabel("Altura");
    private JLabel lbZ = new JLabel("Espessura");
    JTextField tfX = new JTextField(5);
    JTextField tfY = new JTextField(5);
    JTextField tfZ = new JTextField(5);

    public GUIVidros() {

        ClasseControleVidro ccv = new ClasseControleVidro();

        //dados para testes - esses dados terão de vir do banco de dados
        vidro = new Vidro("01", 100, 200, 10);
        ccv.inserir(vidro);
        vidro = new Vidro("02", 150, 500, 8);
        ccv.inserir(vidro);
        vidro = new Vidro("03", 600, 800, 5);
        ccv.inserir(vidro);
        vidro = new Vidro("04", 700, 300, 10);
        ccv.inserir(vidro);
        //////////////////////////
        CentroDoMonitorMaior mon = new CentroDoMonitorMaior();

        setSize(1000,800);
      //  setLocation(mon.getCentroMonitorMaior());
        setLocationRelativeTo(null);
        setTitle("Desenhar retângulos - Vidros");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.setBackground(Color.cyan);
        pnNorte.add(jList);
        pnNorte.setToolTipText("Clic duplo transfere os dados");

        pnNorte.add(pnNorteA);
        pnNorte.add(pnNorteB);

        pnNorteA.add(lbX);
        pnNorteA.add(tfX);
        pnNorteA.add(lbY);
        pnNorteA.add(tfY);
        pnNorteA.add(lbZ);
        pnNorteA.add(tfZ);

        pnNorteB.add(btnDesenhar);

        String[] elementos = ccv.getListaString();
        for (String elemento : elementos) {
            modelo.addElement(elemento);
        }

        jList.setVisibleRowCount(10); // Qtd de Itens visíveis

        jList.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int count = e.getClickCount();
                //  System.out.println("CLICKS " + count);
                if (count > 1) {
                    String aux[] = jList.getSelectedValue().toString().split("-");
                    tfX.setText(aux[1]);
                    tfY.setText(aux[2]);
                    tfZ.setText(aux[3]);
                    clicarBotaoAutomaticamente(btnDesenhar, 0);
                }
            }
        });

        btnDesenhar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vidro = new Vidro("", Integer.valueOf(tfX.getText()),
                        Integer.valueOf(tfY.getText()),
                        Integer.valueOf(tfZ.getText()));
                repaint();
            }
        });

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        desenharVidro(pnCentro, vidro);

    }

    public void desenharVidro(JPanel painel, Vidro vidro) {
        try {
            Graphics painelDoGrafico = painel.getGraphics();
            //painelDoGrafico.drawLine(posX, posY, posX+qtdePontos, posY );

            int alturaDoPainel = pnCentro.getHeight();
            int larguraDoPainel = pnCentro.getWidth();
            int distancia = 20;

            Point cse = new Point(distancia, alturaDoPainel - distancia - vidro.getAltura());
            Point cie = new Point(distancia, alturaDoPainel - distancia);
            Point csd = new Point(distancia + vidro.getLargura(), alturaDoPainel - distancia - vidro.getAltura());
            Point cid = new Point(distancia + vidro.getLargura(), alturaDoPainel - distancia);

            painelDoGrafico.drawLine(cse.x, cse.y, cie.x, cie.y);
            painelDoGrafico.drawLine(cse.x, cse.y, csd.x, csd.y);
            painelDoGrafico.drawLine(csd.x, csd.y, cid.x, cid.y);
            painelDoGrafico.drawLine(cie.x, cie.y, cid.x, cid.y);
        //    painelDoGrafico.drawLine(10, 10, 100, 200);

            painelDoGrafico.drawString(String.valueOf(vidro.getAltura()), csd.x + 5, cid.y - (cid.y - csd.y) / 2);
            painelDoGrafico.drawString(String.valueOf(vidro.getLargura()), Math.abs(cie.x - cid.x) / 2, cid.y + 15);
            painelDoGrafico.drawString("Espessura: "+String.valueOf(vidro.getEspessura())+"mm",Math.abs(cie.x - cid.x) / 2-50, cid.y - (cid.y - csd.y) / 2);

        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
    }

    public void clicarBotaoAutomaticamente(AbstractButton button, int millis) {
        button.doClick(millis);//clica automaticamente um botão após millis segundos
    }

    public static void main(String[] args) {
        new GUIVidros();

    }

}
