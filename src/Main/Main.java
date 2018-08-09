package Main;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

/**
 *
 * https://github.com/rjhalmeman/Lp2_2018.git ramificação: GeradorDeCrud2018
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ferramentas ferramentas = new Ferramentas();
        String nomeClasse = "Pessoa";

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        codigoGerado.add("package Main;");

        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;");
            }
        }

        codigoGerado.add("public class " + nomeClasse + " {");

        //atributos
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add("private " + aux[0] + " " + aux[1] + ";");
        }

        for (int i = 0; i < codigoGerado.size(); i++) {
            System.out.println(codigoGerado.get(i));
        }

        codigoGerado.add("");

        //métodos get
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add(""
                    + "public " + aux[0] + " get" + ferramentas.plMaius(aux[1]) + "() {\n"
                    + "        return " + aux[1] + ";\n"
                    + "    }\n");
        }
        codigoGerado.add("");

        //métodos set
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add(" public void set" + ferramentas.plMaius(aux[1])
                    + "(" + aux[0] + "  " + aux[1] + ") {\n"
                    + "        this. " + aux[1] + " =  " + aux[1] + ";\n"
                    + "    }");
        }

        //Método toString
        String ss = "";
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            ss += aux[1] + "+ \";\"+";

        }
        ss = ss.substring(0, ss.length() - 1);

        codigoGerado.add(" @Override\n"
                + "    public String toString() {\n"
                + "        return " + ss + " ;\n"
                + "    }");

        codigoGerado.add("");
        codigoGerado.add("}");//fim da classe 

        ferramentas.salvarArquivo("src/Main/" + nomeClasse + ".java", codigoGerado);

        //terminou a classe de entidade
        codigoGerado.clear();
        codigoGerado.add("package Main;\n"
                + "\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;");

        //....
        ferramentas.salvarArquivo("src/Main/" + nomeClasse + "Controle.java", codigoGerado);

    }

}
