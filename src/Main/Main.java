/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author cris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa e = new Pessoa();
        System.out.println(e.getIdade() + e.getNome());
        e = new Pessoa(11);
        System.out.println(e.getIdade() + e.getNome());
        e = new Pessoa("maria");
        System.out.println(e.getIdade() + e.getNome());
        e = new Pessoa(55, "pedro");
        System.out.println(e.getIdade() + e.getNome());


        Animal a = new Animal();
        System.out.println(a.som());

        Cachorro c = new Cachorro();
        System.out.println(c.som());

        Todos t = new Todos();
        System.out.println(t.som());

    }
}
