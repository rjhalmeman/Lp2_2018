package Main;

/**
 *
 * @author radames
 */
public class Vidro {

    private String referencia;
    private int altura; //Medidas em milímetros
    private int largura;
    private int espessura;
    //cor?

    public Vidro() {
    }

    public Vidro(String referencia, int largura, int altura, int espessura) {
        this.referencia = referencia;
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
    }

    public int getEspessura() {
        return espessura;
    }

    public void setEspessura(int espessura) {
        this.espessura = espessura;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

}
