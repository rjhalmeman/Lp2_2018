

package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
public class Entidade {
    private double n1;
    private double n2;
    private double n3;
    private double n4;
    private double media;

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }

    public double getN4() {
        return n4;
    }

    public void setN4(double n4) {
        this.n4 = n4;
    }

    public double getMedia() {
        media = (n1+n2+n3+n4)/4;
        return media;
    }

   
    
    
}
