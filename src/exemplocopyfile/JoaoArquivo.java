/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplocopyfile;

// @author Radames
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class JoaoArquivo {

    private String arqOrigem;
    private String arqDestino;

    public List<String> qualOConteudoDaPasta(String caminho) {
        List<String> lista = new ArrayList<>();


        File dir = new File(caminho);

        String[] children = dir.list();
        if (children == null) {
            // Either dir does not exist or is not a directory  
        } else {
            for (int i = 0; i < children.length; i++) {
                // Get filename of file or directory  
                lista.add(children[i]);
            }
        }

        // It is also possible to filter the list of returned files.  
        // This example does not return any files that start with `.'.  
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return !name.startsWith(".");
            }
        };
        children = dir.list(filter);


        // The list of files can also be retrieved as File objects  
        File[] files = dir.listFiles();

        // This filter only returns directories  
        //        FileFilter fileFilter = new FileFilter() {
        //            public boolean accept(File file) {
        //                return file.isDirectory();
        //            }
        //        };
        //        files = dir.listFiles(fileFilter);
        return lista;
    }

    public void copiar(String origem, String destino) {
        try {
            InputStream in;
            in = new FileInputStream(origem);
            OutputStream out;
            byte[] buf = new byte[1024];
            out = new FileOutputStream(destino); // Transferindo bytes de entrada para saída
            int len;
            try {
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } catch (IOException ex) {
                System.out.println("Erro na cópia");
            }
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                System.out.println("Erro na cópia");
            }
        } catch (FileNotFoundException ex) {
           System.out.println("Erro na cópia - arquivo não encontrado");
        }
    }
}
