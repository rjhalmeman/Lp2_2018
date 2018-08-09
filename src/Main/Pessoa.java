package Main;
import java.util.Date;
public class Pessoa {
private int  idPessoa;
private String  nomePessoa;
private Date dataDeNascimentoPessoa;
private double peso;
private double altura;
private String nomeMae;

public int getIdPessoa() {
        return  idPessoa;
    }

public String getNomePessoa() {
        return  nomePessoa;
    }

public Date getDataDeNascimentoPessoa() {
        return dataDeNascimentoPessoa;
    }

public double getPeso() {
        return peso;
    }

public double getAltura() {
        return altura;
    }

public String getNomeMae() {
        return nomeMae;
    }


 public void setIdPessoa(int   idPessoa) {
        this.  idPessoa =   idPessoa;
    }
 public void setNomePessoa(String   nomePessoa) {
        this.  nomePessoa =   nomePessoa;
    }
 public void setDataDeNascimentoPessoa(Date  dataDeNascimentoPessoa) {
        this. dataDeNascimentoPessoa =  dataDeNascimentoPessoa;
    }
 public void setPeso(double  peso) {
        this. peso =  peso;
    }
 public void setAltura(double  altura) {
        this. altura =  altura;
    }
 public void setNomeMae(String  nomeMae) {
        this. nomeMae =  nomeMae;
    }
 @Override
    public String toString() {
        return  idPessoa+ ";"+ nomePessoa+ ";"+dataDeNascimentoPessoa+ ";"+peso+ ";"+altura+ ";"+nomeMae+ ";" ;
    }

}
