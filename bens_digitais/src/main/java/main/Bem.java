
package main;

public abstract class Bem {
    private int quantidade;    
    // fator conversor = 0.05;
    public Bem(int quantidade){
        this.quantidade = quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;  
    }
    public int getQuantidade(){
        return this.quantidade;
    }
    public abstract double converterParaDolar(double dolarComercial);
}
