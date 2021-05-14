// Aluno: Darmes Araujo Dias
package main;

import java.util.Scanner;

/**
 * crio dois vetores de cartas auxiliares, para preenche-los com cartas do topo do baralho.
 * o if else é para entregar as cartas revezando, "uma para um outra para outro".
 * E no final do metódo eu dou set nas mãos dos players, usando os vetores de cartas auxiliares.
 * @author darmes
 */

public class table {
    public static void deal_cards(player x, player y, deck chosen_deck ,int number_of_cards){
        int j=51;
        int counter_1=0, counter_2 = 0;
        card[] aux_1 = new card[number_of_cards];
        card[] aux_2 = new card[number_of_cards];
        
        for(int i = 0; i<(number_of_cards*2) ; i++){
            if(i%2==0){              
                aux_1[counter_1] = new card(chosen_deck.getCard(j).getSuit(), chosen_deck.getCard(j).getValue());
                counter_1++;  
                j--;
            }
            else{
                aux_2[counter_2] = new card(chosen_deck.getCard(j).getSuit(), chosen_deck.getCard(j).getValue());
                counter_2++;  
                j--;
            }
        }
        x.setHand(aux_1);
        y.setHand(aux_2);
        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite quantas cartas serão distribuidas para cada jogador: ");
        int number_of_cards = sc.nextInt();
        deck deck_1 = new deck(); // Construo um objeto deck para nosso jogo
        boolean flag_of_game = false; 
        player A = new player(number_of_cards); // Crio dois objetos player para nosso jogo e "setto" o n° de cartas 
        player B = new player(number_of_cards);
       do{ // Para quando o caso de dar empate e nenhum tiver carta de Ouros, dai troco a variavel flag_of_game pra true para rodar o code novamente
           flag_of_game = false; // se caso o jogo for reembaralhado eu atribuo o false de novo e so mudo na condição certa
           System.out.println((deck_1.shuffle())?"O baralho foi embaralhado!":"O baralho não foi embaralhado!");

            deal_cards(A,B,deck_1,number_of_cards);

            switch(A.the_biggest().comparison(B.the_biggest())){
                case 1: // caso 1 (A possui carta maior que B).
                        System.out.printf("A maior carta do jogador A(%d de %s)é maior que a maior do jogador B(%d de %s).\nJogador A ganhou.", A.the_biggest().getValue(), A.the_biggest().getSuit(), B.the_biggest().getValue(), B.the_biggest().getSuit());
                        break;
                case -1:// caso -1 (B possui carta maior que A).
                        System.out.printf("A maior carta do jogador A(%d de %s) é menor que a maior do jogador B(%d de %s).\nJogador B ganhou.",A.the_biggest().getValue(), A.the_biggest().getSuit(), B.the_biggest().getValue(), B.the_biggest().getSuit());
                        break;
                case 0: // caso 0 (empate). 
                        // desempate: vence quem tiver mais cartas de ouros.
                        boolean flag_A = false; // flag para conferir se A possui cartas de Ouros.
                        boolean flag_B = false;// flag para conferir se B possui cartas de Ouros.
                        for(int j=0;j<number_of_cards;j++){
                            if(A.getHand()[j].getSuit().equals("Ouros")){
                                flag_A = true;
                            }
                            if(B.getHand()[j].getSuit().equals("Ouros")){
                                flag_B = true;
                            }
                        }
                        if(flag_A && flag_B){ // Caso os dois jogares tiverem cartas de Ouros, eu verifico qual tem a MAIOR.
                            card auxiliar_A = new card();
                            card auxiliar_B = new card();
                            for(int i=0;i<number_of_cards;i++){
                               if( (A.getHand()[i].getSuit().equals("Ouros")) && (A.getHand()[i].getValue()> auxiliar_A.getValue()) ){
                                    auxiliar_A.setSuit(A.getHand()[i].getSuit());
                                    auxiliar_A.setValue(A.getHand()[i].getValue());
                               }
                               if( (B.getHand()[i].getSuit().equals("Ouros")) && (B.getHand()[i].getValue()> auxiliar_B.getValue()) ){
                                   auxiliar_B.setSuit(B.getHand()[i].getSuit());
                                    auxiliar_B.setValue(B.getHand()[i].getValue());
                               }
                            }

                            if(auxiliar_A.getValue() > auxiliar_B.getValue()){ // carta de Ouros de A é maior que a carta de Ouros de B.
                                System.out.println("EMPATE!\nO jogador A ganhou, porque tinha uma carta de Ouros maior que a carta de Ouros do jogador B.");
                            }else if(auxiliar_A.getValue() < auxiliar_B.getValue()){ // carta de Ouros de B é maior que a carta de Ouros de A.
                                System.out.println("EMPATE!\nO jogador B ganhou, porque tinha uma carta de Ouros maior que a carta de Ouros do jogador A.");
                            }
                        }
                        else if(flag_A || flag_B){ // Caso apenas um dos dois jogadores possua cartas de Ouros, quem possuir ganha o jogo.
                            if(flag_A)System.out.println("EMPATE!\nO jogador A ganhou, porque só ele possuia uma carta de Ouros.");

                            if(flag_B)System.out.println("EMPATE!\nO jogador B ganhou, porque só ele possuia uma carta de Ouros.");

                        }
                        else{ // Caso nenhum dos jogadores possua cartas de Ouros, da empate mesmo.
                            System.out.println("Reembaralhado...");
                            flag_of_game = true;
                        }
                        break;

            }
        }while(flag_of_game);
        sc.close();
    }
    
}
