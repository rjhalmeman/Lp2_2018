/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

class Animal {

    public String som() {
        return "som de qualquer animal";
    }
}

class Cachorro extends Animal {

    public String som() {
        return "au au au";
    }
}

class Todos extends Animal {

    public String som() {
        return "esta classe TODOS OS SONS e a super classe" + super.som().toUpperCase();
    }
}
/*
class Cachorro extends Animal {
public void som() {
System.out.println("au au au au");
}



public void todos() extends Animal {
this.som(); // saida quando invocado: au au au au
super.som(); // saida quando invocado: som de qualquer animal
}

* 
* 
* */
