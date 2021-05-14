package main;

public class Recurso extends Bem{
    int tipo;
    
    public Recurso(int quantidade,int tipo){
        super(quantidade);
        this.tipo = tipo;
    }
    @Override
    public double converterParaDolar(double dolarComercial){
        return super.getQuantidade()*0.05*this.tipo*dolarComercial;
    }
}
