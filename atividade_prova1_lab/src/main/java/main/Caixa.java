//Alunos: Darmes Araujo Dias, Alex Meireles Santos. 
package main;

import java.util.Scanner;

public class Caixa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque_da_Lu = new Estoque();
        estoque_da_Lu.criarEstoque();
        Venda vendas_da_Lu = new Venda();
        float preco_total=0;
        float preco_de_produto_x_qtd = 0;
        boolean flag = true;
        while(flag){
            System.out.println("===================Produtos===============\n");
            System.out.println("Código: 11111 Descrição:Detergente ABC  Preco: R$1,00\n");
            System.out.println("Código: 22222 Descrição:Sabão em pó OMO  Preco: R$6,50\n");
            System.out.println("Código: 33333 Descrição: Shampoo Beleza Fácil  Preco: R$12,00\n");
            System.out.println("Código: 44444 Descrição: Creme dental Colgate  Preco: R$3,50\n");
            System.out.println("Código: 55555 Descrição: Sabonete Nívea  Preco: R$1,80\n");
            System.out.println("Código: 66666 Descrição: Biscoito Maizena  Preco: R$2,00\n");
            System.out.println("Código: 77777 Descrição: Leite desnatado Parmalat  Preco: R$3,00\n");
            System.out.println("==========================================\n");
            System.out.println("Digite o código do produto desejado:");
            String codigo = sc.nextLine();
            if(estoque_da_Lu.exibirProduto(codigo)!=null){ //  caso ache o produto no estoque
                System.out.printf("PRODUTO ENCONTRADO!\n%s %.2f\n", estoque_da_Lu.exibirProduto(codigo).getDescricao(),estoque_da_Lu.exibirProduto(codigo).getPreco());
                System.out.println("Digite a quantidade:");
                int qtd = sc.nextInt();
                sc.nextLine();
                preco_de_produto_x_qtd = vendas_da_Lu.adicionarNoCarrinho(estoque_da_Lu.exibirProduto(codigo), qtd, estoque_da_Lu);
                if(estoque_da_Lu.quantoEmEstoque(codigo)>= qtd){
                    preco_total += preco_de_produto_x_qtd;
                    System.out.printf("\nPreço da compra: R$%.2f\n",preco_total);
                    System.out.println("\nDeseja colocar no carrinho?(s/n)\n");
                    char escolha_de_compra = sc.next().charAt(0);
                    sc.nextLine();
                    if(escolha_de_compra=='s'){ // realiza a compra e diminui o estoque
                        estoque_da_Lu.compra(codigo,qtd); 
                    }else{ // para fazer outras compras
                        continue;
                    }
                }
                else{
                    System.out.println("\nQuantidade desejada maior que estoque.\n");
                    continue;
                }
            }     
            else{
                System.out.println("\nProduto não encontrado!\n");
                continue;
            }
            System.out.println("\nDeseja continuar comprando?(s/n)\n");
            char escolha = sc.next().charAt(0);
            sc.nextLine();
            if(escolha=='s'){
                continue;
            }
            else{
                System.out.println("\nCompra finalizada!\n");
                flag = false;
            }
        }
        sc.close();
    }
}
