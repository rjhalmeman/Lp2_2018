
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radames
 */
class Controle {
    
    List<Contato> lista = new ArrayList<>();
    
    public Contato buscar(String chave){
        Contato contato = new Contato();
        for (int i = 0; i < lista.size(); i++) {
            if (chave.equals(contato.getId())) {
                return lista.get(i);
            }           
        }
        return null;
    }
    
    public void inserir(Contato contato){
        
    }
    
}
