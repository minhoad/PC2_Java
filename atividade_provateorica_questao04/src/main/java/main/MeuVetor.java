package main;

public class MeuVetor {
    private final Produto[] vetor_de_produtos;
    private int indice=0; // so para adicionar
    
    public MeuVetor(int capacidadeinicial){
        this.vetor_de_produtos = new Produto[capacidadeinicial];
    }
    
    public boolean add(Produto obj){
        if(indice < this.vetor_de_produtos.length){
            this.vetor_de_produtos[indice] = obj; 
            indice++;
        }     
        return true;
    }
    
    public int size(){
        return this.indice;
    }
    
    public Produto get(int indice){
        if(indice < this.vetor_de_produtos.length){ // para verificar se esta entre 0 e size()-1
            return this.vetor_de_produtos[indice];  // se não estiver ia dar pau
        }
        return null; // caso exceder
    }
    
    public void remove(int indice){
        for(int i=indice; (i+1)<vetor_de_produtos.length;i++){
            this.vetor_de_produtos[i].descricao = this.vetor_de_produtos[i+1].descricao;
            this.vetor_de_produtos[i].preco = this.vetor_de_produtos[i+1].preco;
        }
        
        this.vetor_de_produtos[vetor_de_produtos.length-1].descricao = null;
        this.vetor_de_produtos[vetor_de_produtos.length-1].preco = 0;
    }
}

