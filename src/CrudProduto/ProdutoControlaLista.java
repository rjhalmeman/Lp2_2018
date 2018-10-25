package CrudProduto;

import CrudUnidadeDeMedida.UnidadeDeMedida;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

public class ProdutoControlaLista {

    private List<Produto> lista = new ArrayList<>();

    public void inserir(Produto registro) {
        lista.add(registro);
    }

    public Produto retrieve(Produto classe) {
        if (lista.size() > 0) {
            int chaveProcurada = classe.getId();
            int chaveNaLista;
            for (int i = 0; i < lista.size(); i++) {
                chaveNaLista = lista.get(i).getId();
                
                if (chaveNaLista == chaveProcurada) {
                    return lista.get(i);
                }
            }
        }
        return null;//não achou na lista
    }

    public void atualizar(Produto procurado, Produto alterado) {
        lista.set(lista.indexOf(procurado), alterado);
    }
    
    public void excluir(Produto elemento) {
        lista.remove(elemento);
    }
    
    public void getArquivo(String arquivo) {
         lista.clear();
        List<String> listaSTR = new ManipulaArquivo().abrirArquivo(arquivo);
        String[] aux;
        Produto produto;
        for (String linha : listaSTR) {
            aux = linha.split(";");
            produto = new Produto();
            produto.setId(Integer.valueOf(aux[0]));
            produto.setNome(aux[1]);
            produto.setSiglaUnidadeDeMedida(aux[2]);
            produto.setQuantidade_produto(Double.valueOf(aux[3]));
            produto.setPreco_unitario(Double.valueOf(aux[4]));
            lista.add(produto);
        }
        
    }
    
    public void salvarArquivo(String arquivo) {
        
      ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> listaSTR = new ArrayList<>();
        for (Produto linha : lista) {
            listaSTR.add(linha.toString());
        }
        manipulaArquivo.salvarArquivo(arquivo, listaSTR);
    }

    public List<Produto> getLista() {
        return lista;
    }
    
   
} //fim
