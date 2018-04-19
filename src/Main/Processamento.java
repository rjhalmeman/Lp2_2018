
package Main;

public class Processamento {

    double n1;
    double n2;  
    double n3;
    double t;
    double m;
    String c;

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

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getM() {
        m=(n1+n2*2+n3*3+t)/7;

        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public String getC() {
        if (m<4.0) {
            return "E";
        }
        if (m<6.0) {
            return "D";
        }
        if (m<7.5) {
            return "C";
        }
        if (m<9.0) {
            return "B";
        }
        if (m>=9.0) {
            return "A";
        }
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
   
}
