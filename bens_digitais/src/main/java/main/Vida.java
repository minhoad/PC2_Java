package main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Vida extends Bem{
    private String validaAte;
    
    public Vida(int quantidade,String validaAte){
        super(quantidade);
        this.validaAte = validaAte;
    }
    public boolean ehValida(){   
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataParametro = LocalDate.parse(this.validaAte,dtf);
        if(dataAtual.isBefore(dataParametro)){
            return true;
        }
        return false;
    }
    
    @Override
    public double converterParaDolar(double dolarComercial){
        if(this.ehValida())return super.getQuantidade()*0.2*dolarComercial;
        return 0; // se não for valida não tem valor
    }
    
}
