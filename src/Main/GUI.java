package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import Geradores.GerarClasseDeControle;
import Geradores.GerarClasseDeEntidade;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import myTools.Ferramentas;

public class GUI extends JFrame {

    private Container cp;
    private JLabel labelNomeProjetoAlvo = new JLabel("Projeto Alvo");//onde serão gerados os códigos
    private JTextField tfProjeto = new JTextField(50);
    private JPanel painelNorte = new JPanel();
    private JPanel painelCentro = new JPanel();
    private JPanel painelSul = new JPanel();

    private JButton botaoEscolherProjetoDestino = new JButton("Abrir projeto");
    private JButton botaoGerarClasseEntidade = new JButton("Gerar Entidade");
    private JButton botaoGerarClasseControle = new JButton("Gerar Controle");

    private JLabel labelArqTexto = new JLabel("Nome do arquivo da entidade");
    private JTextField textFieldArquivoTexto = new JTextField(50);

    private JFileChooser caixaDeDialogo = new JFileChooser();
    private String caminho = "/home";
    private List<String> arqUltimaExecucao = new ArrayList<>();
    Ferramentas ferramentas = new Ferramentas();

    public GUI() {

        //carregar arquivo da última execução
        arqUltimaExecucao = ferramentas.abrirArquivo("UltimaExecucao.dat");// 
        if (arqUltimaExecucao != null) {
            caminho = arqUltimaExecucao.get(0);
            //   System.out.println("caminho last " + caminho);
            tfProjeto.setText(caminho);
        }

        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gerador de código 2018");
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelCentro, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelNorte.add(labelArqTexto);
        painelNorte.add(textFieldArquivoTexto);

        painelSul.add(labelNomeProjetoAlvo);
        painelSul.add(tfProjeto);

        painelCentro.add(botaoGerarClasseEntidade);
        painelCentro.add(botaoGerarClasseControle);

        painelSul.add(botaoEscolherProjetoDestino);

        botaoEscolherProjetoDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("DIRETÓRIO", "..", "..");
                caixaDeDialogo.setFileFilter(filter);
                caixaDeDialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                File file = new File(caminho);
                if (file.exists()) {
                    caixaDeDialogo.setCurrentDirectory(file);
                } else {
                    file = new File("/home");
                    if (file.exists()) {
                        caixaDeDialogo.setCurrentDirectory(file);
                    } else {
                        caixaDeDialogo.setCurrentDirectory(null);
                    }

                }
                if (caixaDeDialogo.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                    caminho = caixaDeDialogo.getSelectedFile().getAbsolutePath();
                    tfProjeto.setText(caminho);
                    arqUltimaExecucao = new ArrayList<>();
                    arqUltimaExecucao.add(caminho);
                    int arq = ferramentas.salvarArquivo("UltimaExecucao.dat", arqUltimaExecucao);

                    if (arqUltimaExecucao != null) {
                        caminho = arqUltimaExecucao.get(0);
                        tfProjeto.setText(caminho);
                        // listaAtributo = new ArrayList();
                        tfProjeto.setBackground(Color.green);
                    }
                }

            }
        });

        botaoGerarClasseEntidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerarClasseDeEntidade gerarClasseDeEntidade
                        = new GerarClasseDeEntidade(tfProjeto.getText(), textFieldArquivoTexto.getText());
            }
        });

        botaoGerarClasseControle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Geradores.GerarClasseDeControle gcc
                        = new GerarClasseDeControle(tfProjeto.getText(), textFieldArquivoTexto.getText());
            }
        });

        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
