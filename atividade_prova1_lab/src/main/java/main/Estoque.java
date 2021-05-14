package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A classe Estoque possui dois membros, um ArrayList estoque_da_loja que armazena tipo Produto com 7 posições 
 * e o HashMap qtdprodutos que armazena usando a key como o código do produto e o valor a quantidade daquele produto em estoque.
 * 
 * Temos um construtor que instancia o objeto com os dois componentes.
 * 
 * O metódo criarEstoque já setta o Arraylist com os produtos que estamos oferecendo(exemplo: Detergente ABC com codigo 11111 e preço 1 real).
 * E preenche o HashMap qtdprodutos.
 * 
 * O metódo exibir produto pede ao usuário seu código e retorna um produto, caso o código não seja encontrado na lista retorna-se null.
 * 
 * O metódo compra pede ao usuário o código do objeto e a quantidade daquele objeto que ele deseja, se a quantidade estiver em estoque, realiza-se a compra.
 * Retorna-se true caso a condição for atendida, ou seja, a compra deu certo.Caso contrário retorna-se false.
 * @author darmes
 */


public class Estoque {
    ArrayList<Produto> estoque_da_loja;
    private Map<String,Integer> qtdprodutos;
    
    public Estoque(){
        this.estoque_da_loja = new ArrayList();
        this.qtdprodutos = new HashMap<>(); // qtdprodutos é um hashmap com chave = codigo e valor = qtd
    }
    // Quantidade arbitrária que a gente escolheu de cada produto = 10
    public void criarEstoque(){
        Produto[] estoque_auxiliar;
        estoque_auxiliar = new Produto[7];
        estoque_auxiliar[0] = new Produto("11111", "Detergente ABC",(float)1); 
        estoque_auxiliar[1] = new Produto("22222", "Sabão em pó OMO",(float)6.5);
        estoque_auxiliar[2] = new Produto("33333", "Shampoo Beleza Fácil", (float)12);
        estoque_auxiliar[3] = new Produto("44444", "Creme dental Colgate", (float)3.5);
        estoque_auxiliar[4] = new Produto("55555", "Sabonete Nívea", (float)1.8);
        estoque_auxiliar[5] = new Produto("66666", "Biscoito Maizena", (float)2);
        estoque_auxiliar[6] = new Produto("77777", "Leite desnatado Parmalat", (float)3);
        for(int i=0; i<7;i++){
            this.estoque_da_loja.add(estoque_auxiliar[i]);
            this.qtdprodutos.put(estoque_auxiliar[i].getCodigo(),10);
        }
    }
    
    public Produto exibirProduto(String codigo_do_produto){
        for( Produto x : this.estoque_da_loja){
            if(x.getCodigo().equals(codigo_do_produto)){
                return x;
            }
        }
        return null; // vazio, pois não achou
    }
    
    public boolean compra(String codigo,Integer qtd){
        if(qtd<=this.qtdprodutos.get(codigo)){
           this.qtdprodutos.put(codigo ,this.qtdprodutos.get(codigo)-qtd);
            return true; // ROLOU A COMPRA
        }
        return false; // TEM MENOS QTD DO QUE O CLIENTE SOLICITOU
    }
    
    public int quantoEmEstoque(String codigo){
        return this.qtdprodutos.get(codigo);
    }
    
}
