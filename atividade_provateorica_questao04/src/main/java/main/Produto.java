package main;

public class Produto {
    public String descricao;
    public double preco;
    
    public Produto(String descricao, double preco){
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public double getPreco(){
        return this.preco;
    }
}
