

package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calcular {
    private int anoNasc;
    private int idade;
    private String podeOQue;

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public int getIdade() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int anoAtual = Integer.valueOf(sdf.format(new Date()));
        idade = anoAtual - anoNasc;
        if (idade<16) {
            setPodeOQue("nada");
        } else if (idade<18) {
            setPodeOQue("votar");
        } else {
            setPodeOQue("votar e dirigir");
        }
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPodeOQue() {
        return podeOQue;
    }

    public void setPodeOQue(String podeOQue) {
        this.podeOQue = podeOQue;
    }
    
    
}
