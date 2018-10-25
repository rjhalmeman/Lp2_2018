package CrudProduto;
public class Produto implements java.io.Serializable {
private int id;
private String nome;
private String siglaUnidadeDeMedida;
private double quantidade_produto;
private double preco_unitario;

public void setId(int id){
this.id=id;
}

public void setNome(String nome){
this.nome=nome;
}

public void setSiglaUnidadeDeMedida(String siglaUnidadeDeMedida){
this.siglaUnidadeDeMedida=siglaUnidadeDeMedida;
}

public void setQuantidade_produto(double quantidade_produto){
this.quantidade_produto=quantidade_produto;
}

public void setPreco_unitario(double preco_unitario){
this.preco_unitario=preco_unitario;
}


public int getId(){
return this.id;
}

public String getNome(){
return this.nome;
}

public String getSiglaUnidadeDeMedida(){
return this.siglaUnidadeDeMedida;
}

public double getQuantidade_produto(){
return this.quantidade_produto;
}

public double getPreco_unitario(){
return this.preco_unitario;
}


@Override
    public String toString() { return 
this.id+";"+this.nome+";"+this.siglaUnidadeDeMedida+";"+this.quantidade_produto+";"+this.preco_unitario;
}
}
