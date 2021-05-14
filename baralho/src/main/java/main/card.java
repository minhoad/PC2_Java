package main;

public class card {
    private String suit;
    private int value;
    
    public card(){
        this.suit  = " "; // troquei a atribuição de null para " " 
        this.value = 0;
    }
    
    public card(String suit, int value){
        this.suit = suit;
        this.value = value;
    }
    
    public void setSuit(String suitSetted){
        this.suit = suitSetted;
    }
    
    public void setValue(int valueSetted){
        this.value = valueSetted;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public String getSuit(){ 
        return this.suit;
    }
    
    public int comparison(card x){
        //uso de operadores "<" e ">" pois eles são usados para comparar tipos primitivos(int, por exemplo)
        if(this.value > x.value){
            return 1; // Caso a carta "atual" seja maior que a outra carta
        }
        else if(this.value < x.value){ // 
            return -1; // Caso a carta "atual" seja menor que a outra carta 
        }
        return 0; // Caso a carta "atual" seja igual a outra carta
    }
    
}
