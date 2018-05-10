
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radames
 */
public class Controle {
    
    List<Contato> lista = new ArrayList<>();
    
   
    
    public Contato buscar(String chave){                   
        for (int i = 0; i < lista.size(); i++) {
            if (chave.equals(lista.get(i).getId())) {
                return lista.get(i);
            }           
        }
        return null;
    }
    
    public void inserir(Contato contato){
        lista.add(contato);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getId()+"-"+
                    lista.get(i).getNome());
        }
    }

    public Controle() {
//        Contato contato = new Contato();
//        Contato contato1 = new Contato("1","111","11111");
        lista.add(new Contato("1","111","11111"));
        lista.add(new Contato("2","222","22222"));
        lista.add(new Contato("3","333","33333"));
    }

    void alterar(Contato contatoOriginal, Contato contatoAlterado) {
        lista.set(lista.indexOf(contatoOriginal), contatoAlterado);
    }
    
}
