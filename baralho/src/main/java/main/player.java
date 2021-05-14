
package main;

public class player {
    private card[] my_hand;

    
    public player(int number_of_cards){ // construtor da mão, peço como parâmetro o número de cartas que o jogador tem
        this.my_hand = new card[number_of_cards];
    }
    
    public void setHand(card[] hand){ // "setta" a mão do jogador
        this.my_hand = hand;
    }
    
    public card[] getHand(){
        return this.my_hand;
    }
    
    public card the_biggest(){
        card auxiliar = new card(); // auxiliar é criada com suit = " " e value = 0
        int index_local = 0; 
        for(int i=0;i<this.my_hand.length;i++){
            if((this.my_hand[i].comparison(auxiliar)) == 1){
                auxiliar.setValue(this.my_hand[i].getValue()); // Apenas o valor importa
                index_local = i;
            }
        }
        return this.my_hand[index_local]; // retorna a posição da maior carta na mão do jogador
    }
    
}
