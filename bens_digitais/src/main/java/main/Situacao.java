package main;

import java.util.ArrayList;

public class Situacao {
   private ArrayList<Bem> bens; 
   
   public Situacao(){
       this.bens = new ArrayList();
   }
   
   public void addBens(Bem x){
       this.bens.add(x);
   }
   
   public double calculaValorInventario(){
       double total = 0;
       for(Bem bem : bens){
           total += bem.converterParaDolar(5.60);
       }
       return total;
   }
}
