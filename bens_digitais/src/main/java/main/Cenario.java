package main;

public class Cenario extends Bem{
    private int tamanho;
    private int nivel;
    
    public Cenario(int quantidade, int tamanho, int nivel){
        super(quantidade);
        this.tamanho = tamanho;
        this.nivel = nivel;
    }
    @Override
    public double converterParaDolar(double dolarComercial){
        return super.getQuantidade()*0.05*this.nivel*this.tamanho*dolarComercial;
    }
}
