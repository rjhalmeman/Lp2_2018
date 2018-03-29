package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
public class MediaPonderada {

    private double nota1;
    private double nota2;
    private double nota3;
    private double media;
    private String situacao;

    public double getMedia() {

        /*
         Escreva um programa que leia o código de um aluno e 
        suas três notas. Calcule a média ponderada do aluno, 
        considerando que o peso para a maior nota seja 4 e 
        para as duas restantes, 3. Mostre o código do aluno, 
        suas três notas, a média calculada e uma mensagem 
        "APROVADO" se a média for maior ou igual a 6 e 
        "REPROVADO" se a média for menor que 6.

         */
        double aux;
        if (nota1 > nota2) {
            aux = nota1;
            nota1 = nota2;
            nota2 = aux;
        }
        if (nota2 > nota3) {
            aux = nota2;
            nota2 = nota3;
            nota3 = aux;
        }
        if (nota1 > nota2) {
            aux = nota1;
            nota1 = nota2;
            nota2 = aux;
        }
        media = (nota3 * 4 + nota2 * 3 + nota1 * 3) / 10;
        if (media >= 6) {
            setSituacao("Aprovado");
        } else {
            setSituacao("Reprovado");
        }
        return media;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

}
