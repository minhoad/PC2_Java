/*Alunos: Darmes Dias, Alex Meireles*/
package main;

import java.util.Scanner;


public class teste {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MeuVetor lista_de_produtos = new MeuVetor(3);
        Produto x = new Produto("Arroz integral", 8.50);
        Produto y = new Produto("Feijão Preto", 4.00);
        Produto z = new Produto("Cachaça da boa", 7.50);
        lista_de_produtos.add(x);
        lista_de_produtos.add(y);
        lista_de_produtos.add(z);
        
        for(int i=0; i<lista_de_produtos.size();i++){ // printa a lista dos produtos
            System.out.println(lista_de_produtos.get(i).getDescricao());
            System.out.println(lista_de_produtos.get(i).getPreco());
        }
        
        System.out.println("Digite o nome do produto que deseja saber o indice: ");
        String Input =  sc.nextLine();
        
        if(encontrar(lista_de_produtos,Input)<lista_de_produtos.size()){ 
            lista_de_produtos.remove(encontrar(lista_de_produtos,Input));
        }
        else{ // caso o método encontrar tiver retornado (x.size()+1) vai ultrapassar o tamanho da lista
            System.out.println("Produto não encontrado!");
        }
        for(int i=0; i<lista_de_produtos.size();i++){
            if((lista_de_produtos.get(i).getDescricao()!=null) && (lista_de_produtos.get(i).getPreco()!=0)){
                System.out.println(lista_de_produtos.get(i).getDescricao());
                System.out.println(lista_de_produtos.get(i).getPreco());
            }
        }
              sc.close();
}
    public static int encontrar(MeuVetor x,String y){ // vc quer remover y do vetor x
        for(int i=0; i<x.size() ;i++){
            if(x.get(i).getDescricao().equals(y)){
                return i; // indice do produto desejado
            }
        }
        return (x.size()+1); // ultrapassa o tamanho do vetor
    }
}
