package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
public class Processamento {

    private int qtXSalada;
    private int qtXEgg;
    private int qtXFrango;
    private int qtXTudo;
    private int qtXNerd;

    private double precoXSalada;
    private double precoXEgg;
    private double precoXFrango;
    private double precoXTudo;
    private double precoXNerd;

    private double subTotalXSalada;
    private double subTotalXEgg;
    private double subTotalXFrango;
    private double subTotalXTudo;
    private double subTotalXNerd;

    private double total;

    public int getQtXSalada() {
        return qtXSalada;
    }

    public void setQtXSalada(int qtXSalada) {
        this.qtXSalada = qtXSalada;
    }

    public int getQtXEgg() {
        return qtXEgg;
    }

    public void setQtXEgg(int qtXEgg) {
        this.qtXEgg = qtXEgg;
    }

    public int getQtXFrango() {
        return qtXFrango;
    }

    public void setQtXFrango(int qtXFrango) {
        this.qtXFrango = qtXFrango;
    }

    public int getQtXTudo() {
        return qtXTudo;
    }

    public void setQtXTudo(int qtXTudo) {
        this.qtXTudo = qtXTudo;
    }

    public int getQtXNerd() {
        return qtXNerd;
    }

    public void setQtXNerd(int qtXNerd) {
        this.qtXNerd = qtXNerd;
    }

    public double getPrecoXSalada() {
        return precoXSalada;
    }

    public void setPrecoXSalada(double precoXSalada) {
        this.precoXSalada = precoXSalada;
    }

    public double getPrecoXEgg() {
        return precoXEgg;
    }

    public void setPrecoXEgg(double precoXEgg) {
        this.precoXEgg = precoXEgg;
    }

    public double getPrecoXFrango() {
        return precoXFrango;
    }

    public void setPrecoXFrango(double precoXFrango) {
        this.precoXFrango = precoXFrango;
    }

    public double getPrecoXTudo() {
        return precoXTudo;
    }

    public void setPrecoXTudo(double precoXTudo) {
        this.precoXTudo = precoXTudo;
    }

    public double getPrecoXNerd() {
        return precoXNerd;
    }

    public void setPrecoXNerd(double precoXNerd) {
        this.precoXNerd = precoXNerd;
    }

    public double getSubTotalXSalada() {
        subTotalXSalada = qtXSalada * precoXSalada;
        return subTotalXSalada;
    }

    public double getSubTotalXEgg() {
        subTotalXEgg = qtXEgg * precoXEgg;
        return subTotalXEgg;
    }

    public double getSubTotalXFrango() {
        subTotalXFrango = qtXFrango * precoXFrango;
        return subTotalXFrango;
    }

    public double getSubTotalXTudo() {
        return subTotalXTudo;
    }

    public double getSubTotalXNerd() {
        return subTotalXNerd;
    }

    public double getTotal() {
        total = qtXSalada * precoXSalada;
        total += qtXEgg * precoXEgg;
        total += qtXFrango * precoXFrango;
        total += qtXTudo * precoXTudo;
        total += qtXNerd * precoXNerd;
        return total;
    }

}
