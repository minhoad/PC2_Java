package main;

public class Seguidor extends Bem{
    private int fatorImpacto;
    
    public Seguidor(int quantidade, int fatorImpacto){
        super(quantidade);
        this.fatorImpacto = fatorImpacto;
    }
    
    @Override
    public double converterParaDolar(double dolarComercial){
        return super.getQuantidade()*0.05*this.fatorImpacto*dolarComercial;
    }
}
