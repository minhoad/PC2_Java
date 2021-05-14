package main;

import java.security.SecureRandom;

public class deck {
    private card[] my_deck;  // declaro um array
    private final String[] suit_s = {"Ouros","Copas","Paus","Espadas"}; // Naipes
    SecureRandom random = new SecureRandom();
    
    /**
        * Como é padrão esse padrão de cartas eu não preciso de referenciar com o ponteiro "this"
        * Porque todos os objetos a serem criados o valor de inicialização de my_deck deve ser esse
        */
    
    public deck(){ // Construtor do nosso baralho
        my_deck = new card[52]; // cria o objeto array atribuindo 52 posições  
        int counter = 0;
        for(String suit: suit_s){
            for(int i=0;i<13;i++){
                my_deck[counter] = new card(suit, i+1);
                counter++;
            }
        }
    }
    /**
         * O metódo shuffle(); embaralha o nosso baralho.
         * 
         * Usamos o objeto random da class SecureRandom para escolher posições aleatórias, para trocar cartas.
         * 
         * Troca de posição entre cartas aleatórias, com o intuito de embaralhar o nosso baralho,
         * nessa troca usamos como base a troca de elementos entre dois copos, sem desperdiçar, ou seja,
         * precisa de um auxiliar.
         *
         * o metódo retorna true caso o deck seja embaralhado com sucesso.
         * 
         *
         *
         * @return true quando o baralho é embaralhado.
         */
    
    public boolean shuffle(){ 
        card auxiliar = new card(); 
        int index = 0;      
        for(int i = 0; i<52 ; i++){
            index = random.nextInt(52);
            auxiliar.setSuit(this.my_deck[i].getSuit());
            auxiliar.setValue(this.my_deck[i].getValue());
            
            this.my_deck[i].setSuit(this.my_deck[index].getSuit());
            this.my_deck[i].setValue(this.my_deck[index].getValue());
            
            this.my_deck[index].setSuit(auxiliar.getSuit());
            this.my_deck[index].setValue(auxiliar.getValue());
        
        }
        return true; // informa que o deck foi embaralhado
    }
    
    public card getCard(int position){
        return this.my_deck[position]; // retorna a carta no baralho naquela posição
    }
    
}
