package main;
import java.util.ArrayList;

public class ItemOrcamentoComplexo {
    private ArrayList<String> descricao_gastos_previstos;
    private double valor_total;
    
    public ItemOrcamentoComplexo(){
        this.descricao_gastos_previstos = new ArrayList<>();
        this.valor_total = 0;
    }
    
    public ItemOrcamentoComplexo(String descricao_gastos_previstos, double valor_total) {
        
        this.descricao_gastos_previstos = new ArrayList<>();
        for(String d:descricao_gastos_previstos.split("; ")){
            this.descricao_gastos_previstos.add(d);
        }
        this.valor_total = valor_total;
    }
    
    public ArrayList<String> get_descricao_gastos_previstos(){
        return this.descricao_gastos_previstos;
    }
    public void print(){
        System.out.println("Item orçamento");
        for(String s:descricao_gastos_previstos){
            System.out.println(s);
            
        }
        System.out.println(valor_total+"\n");
    }
}
