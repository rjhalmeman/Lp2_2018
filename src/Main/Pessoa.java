/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

public class Pessoa{  
  
    private String nome;  
    private int idade;  
  
    //Construtor pra inicializar campos com valores padrão  
    public Pessoa(){  
        nome = "Eugênio";  
        idade = 24;  
    }  
      
    //Construtor pra inicializar somente idade com o valor informado pelo usuário  
    public Pessoa(int i){        
        idade = i;  
    }  
      
    //Contrutor pra inicializar somente nome com o valor informado pelo usuário  
    public Pessoa(String n){         
        nome = n;  
    }  
    public Pessoa(int idade, String nome){  
        this.nome = nome;  
        this.idade = idade;  
    }  
      
    //métodos get e set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
    
}  
