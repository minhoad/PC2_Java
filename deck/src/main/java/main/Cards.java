package main;

public class Cards {
    private String suit;
    private int value;
    public Cards(){ // Construtor inicializador
        this.suit = " ";
        this.value = 0;
    }
    public Cards(String suit,int value){// Construtor
        this.suit = suit;
        this.value = value;
    }
    
    public void setSuit(String suitSetted){ // setando o naipe
        this.suit = suitSetted; 
    }
    public void setValue(int valueSetted){ // setando o valor
        this.value = valueSetted;
    }
    
    public String getSuit(){ // retorna o naipe da carta "atual"
        return this.suit;
    }
    
    public int getValue(){// retorna o valor da carta "atual"
        return this.value;
    }
   
    // As verificações só precisam de um parâmetro porque temos com usar o ponteiro this para referenciar o objeto "atual"
    public int comparison(Cards x){
        if(this.value > x.value){
            return 1; // Caso a carta "atual" seja maior que a outra carta
        }
        else if(this.value == x.value){ // uso o operador "==" pois ele é usado para comparar tipos primitivos
            return 0; // Caso a carta "atual" seja igual a outra carta
        }
        return -1; // Caso a carta "atual" seja menor que a outra carta
    }
    public boolean isequalsuit(Cards x){
        if(this.suit.equals(x.suit)){
            return true; // Caso as duas cartas forem do mesmo naipe
        }
        return false;// Caso as duas cartas forem de naipes diferentes
    }  
}
