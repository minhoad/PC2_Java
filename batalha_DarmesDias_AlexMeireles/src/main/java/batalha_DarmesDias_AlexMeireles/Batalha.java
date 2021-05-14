//Alunos: Darmes Dias e Alex Meireles

package batalha_DarmesDias_AlexMeireles;

import java.util.Scanner;

public class Batalha {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        int pontos_jogador1 = 0;
        int pontos_jogador2 = 0;
        boolean flag = true, repetiu=false;
        int input_linha;
        int contador_de_jogadas = 0;
        int contador_de_jogadas_p1 = 0;
        int contador_de_jogadas_p2 = 0;
        //Criando os tipos de espadas padrões

        Espada espada1 = new Espada("Espada de ouro",50);
        Espada espada2 = new Espada("Espada de bronze",40);
        Espada espada3 = new Espada("Espada de platina",30);
        Espada espada4 = new Espada("Espada de gelo",20);
        Espada espada5 = new Espada("Espada de alumínio",10);
        Espada espada6 = new Espada("Espada de madeira",5);
        
        Espada[] tipos_de_espadas = {espada1,espada2,espada3,espada4,espada5,espada6};
        
        //Fase de posicionamento de espadas
        for(int i=0; i<2 ; i++){
            for(int j=0; j<6 ; j++){
                System.out.println("Em qual linha você deseja posicionar a "+ tipos_de_espadas[j].getDescricao()+"(1 a 13):");
                input_linha = in.nextInt();
                input_linha-=1;
                in.nextLine();
                System.out.println("Em qual coluna você deseja posicionar a "+ tipos_de_espadas[j].getDescricao()+"(A a M):");
                String input_coluna = in.nextLine();
                Jogada posicionar = new Jogada(input_linha, input_coluna);
                
                if(i==0){
                    jogador1.setTabuleiro(posicionar, tipos_de_espadas[j]);
                }
                if(i==1){
                    jogador2.setTabuleiro(posicionar, tipos_de_espadas[j]);
                }
            }
        }
        Jogada x = new Jogada(); // Jogadas auxiliares para ver se repetiram
        Jogada z = new Jogada(); // Para que o jogador não possa ganhar pontos jogando sempre a mesma posição
        
        //Fase de jogadas
        while(flag){
            repetiu = false;
            if(contador_de_jogadas%2==0){ // Para ser cada hora um que joga
                
                System.out.println("Vez do jogador 1:");
                System.out.println("Digite a linha(1 a 13):");
                input_linha = in.nextInt();
                input_linha-=1;
                in.nextLine();
                System.out.println("Digite a coluna(A a M):");
                String input_coluna = in.nextLine();
                
                x.setLinha(input_linha);
                x.setColuna(input_coluna);
                
                for(Jogada y:jogador1.getMinhasJogadas()){
                    if(x.getColuna()==y.getColuna() && x.getLinha() == y.getColuna()){
                        repetiu=true;
                    }
                }
                if(repetiu){
                    System.out.println("Você já fez essa jogada.");
                    continue;
                }
                jogador1.addJogadas(input_linha, input_coluna);
                
                
                if(jogador1.confereAcerto(jogador1.getMinhasJogadas().get(contador_de_jogadas_p1),jogador2)){
                    pontos_jogador1 += jogador2.getTabuleiro()[jogador1.getMinhasJogadas().get(contador_de_jogadas_p1).getLinha()][jogador1.getMinhasJogadas().get(contador_de_jogadas_p1).getColuna()].getValor();
                    System.out.println("Pontuação do Jogador 1:"+pontos_jogador1);
                }
                
                contador_de_jogadas_p1++;
            }
            
            else if(contador_de_jogadas%2!=0){// Para ser cada hora um que joga
                System.out.println("Vez do jogador 2:");
                System.out.println("Digite a linha(1 a 13):");
                input_linha = in.nextInt();
                input_linha-=1;
                in.nextLine();
                System.out.println("Digite a coluna(A a M):");
                String input_coluna = in.nextLine();
                
                z.setLinha(input_linha);
                z.setColuna(input_coluna);
                
                for(Jogada w:jogador2.getMinhasJogadas()){
                    if(z.getColuna()== w.getColuna() && z.getLinha() == w.getLinha()){
                        repetiu = true;
                    }
                }
                
                if(repetiu){
                    System.out.println("Você já fez essa jogada.");
                    continue;
                }
                jogador2.addJogadas(input_linha, input_coluna);
                
                if(jogador2.confereAcerto(jogador2.getMinhasJogadas().get(contador_de_jogadas_p2),jogador1)){
                    pontos_jogador2+= jogador1.getTabuleiro()[jogador2.getMinhasJogadas().get(contador_de_jogadas_p2).getLinha()]
                            [jogador2.getMinhasJogadas().get(contador_de_jogadas_p2).getColuna()].getValor();
                    System.out.println("Pontuação do Jogador 2:"+pontos_jogador2);
                    
                }
                contador_de_jogadas_p2++;
            }
           
            if(pontos_jogador1 == 155 || pontos_jogador2 == 155){
                flag = false;
            }
            contador_de_jogadas++;
        }
        
        
        if(pontos_jogador1==155){
            System.out.println("Jogador 1 ganhou!");
        }
        if(pontos_jogador2==155){
            System.out.println("Jogador 2 ganhou!");
        }
        in.close();
    }
}
