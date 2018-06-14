package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radames
 */
public class ClasseControleVidro {

    private List<Vidro> lv = new ArrayList<>();

    public boolean inserir(Vidro v) {
        int i = lv.indexOf(v); //evita que sejam inseridos repetidos
        if (i < 0) {
            lv.add(v);
            return true;
        } else {
            return false;
        }
    }

    public List<Vidro> getLista() {
        return lv;
    }

    public String[] getListaString() {
        String[] ss = new String[lv.size()];
        for (int i = 0; i < lv.size(); i++) {
            ss[i] = lv.get(i).getReferencia() + "-"
                    + lv.get(i).getAltura() + "-"
                    + lv.get(i).getLargura() + "-"
                    + lv.get(i).getEspessura();
        }
        return ss;
    }

    public Vidro getVidroPorRef(String ref) {
        for (int i = 0; i < lv.size(); i++) {
            if (lv.get(i).getReferencia().equals(ref)) {
                return lv.get(i);
            }
        }
        return null;
    }

}
