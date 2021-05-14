package main;


public class Ferramenta extends Bem {
    private String Acao;
    
    public Ferramenta(int quantidade,String Acao){
        super(quantidade);
        this.Acao = Acao;
    }
    @Override
    public double converterParaDolar(double dolarComercial){
        double aux=1;
        if(this.Acao.equals("defesa")){
            aux = 0.3;
        }else if(this.Acao.equals("destruição")){
            aux = 0.2;
        }
        else if(this.Acao.equals("invisibilidade")){
            aux = 0.1;
        }
        return super.getQuantidade()*0.05*aux*dolarComercial;
    }
}
