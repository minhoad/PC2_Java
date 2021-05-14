package main;

import java.util.ArrayList;

/**
 * Na class Venda temos um membro ArrayList meu_carrinho que armazena o tipo Produto.
 * 
 * Possuimos um contrutor que instancia o objeto com um componente.
 * 
 * O metódo adicionarNoCarrinho preenche o ArrayList meu_carrinho com os itens escolhidos e soma ao preço total
 * quando o estoque possui aquela quantidade de produtos. Caso o estoque não possua, ele retorna -1(Para a class Caixa
 * printar que não tem a quantidade de produtos desejados). Caso o Estoque possua retornamos o preço daquela quantia de produtos.
 * 
 * @author darmes
 */

public class Venda {
    ArrayList<Produto> meu_carrinho;
    
    public Venda(){ // Construtor do carrinho do cliente
        meu_carrinho = new ArrayList<>();
    }
    
    public float adicionarNoCarrinho(Produto x, int qtd, Estoque Lu){
        float preco = 0;
        for(int i=0;i<qtd;i++){
            this.meu_carrinho.add(x);
            if(qtd<=Lu.quantoEmEstoque(x.getCodigo())){
                preco+=x.getPreco();
            }
            else{
                return -1;
            }
        }
        return preco;
    }
    
}
