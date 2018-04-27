package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radames
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ferramentas ferramentas = new Ferramentas();
        double x = 4.0 / 3.0;
        System.out.println("Formatando o número double =>" + x);
        //exemplo para uso de um médodo criado na classe ferramentas        
        System.out.println("Número formatado = " + ferramentas.doubleFormatado(x));

        //Instancia uma lista de String - vazia
        List<String> ls = new ArrayList<>();

        //adiciona elementos na lista
        ls.add("Ayla");
        ls.add("Aryane");
        ls.add("Camila");
        ls.add("Thais");
        ls.add("Patricia");
        ls.add("Gabriel");
        ls.add("Sophia");
        ls.add("Alexandre");
        ls.add("Radames");
        //usa o método salvarArquivo da classe Ferramentas para salvar a lista em arquivo

        // String caminho = "/home/radames/Documentos/TURMA.txt";
        //quando não é informado um caminho (pastas) o documento é salvo na pasta do projeto
        String caminho = "TURMA.txt";
        ferramentas.salvarArquivo(caminho, ls);

        ///////////////////////  Buscar os dados no disco e preencher a lista  /////////////
        ls.clear();//limpar a lista
        ls = ferramentas.abrirArquivo(caminho);
        //mostrar todos os elementos
        
        System.out.println("\n\n ----- todos os elementos da lista -----");
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(i + "-" + ls.get(i));
        }

        ls.remove(4); //remove o quinto elemento da lista (começa em zero)
        ls.set(4, "Gabriel Lemos"); //muda o nome do quinto elemento
        int posicao = ls.indexOf("Sophia"); //procura Sophia na lista
        System.out.println("A posicao da Sophia na lista é " + posicao);// se encontrar, mostra 

        System.out.println("\n --------- mostrar as alterações ---------");
        //mostra todos os elementos da lista
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(i + "-" + ls.get(i));
        }

    }

}
