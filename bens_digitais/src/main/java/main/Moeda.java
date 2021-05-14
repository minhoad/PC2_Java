package main;

public class Moeda extends Bem {
    private int nivel;
    public Moeda(int quantidade,int nivel){
        super(quantidade);
        this.nivel = nivel;
    }
    @Override
    public double converterParaDolar(double dolarComercial){
        return super.getQuantidade()*this.nivel*0.05*dolarComercial;
    }
}
