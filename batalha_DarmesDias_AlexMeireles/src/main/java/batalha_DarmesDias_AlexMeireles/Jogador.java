//Alunos: Darmes Dias e Alex Meireles
package batalha_DarmesDias_AlexMeireles;

import java.util.ArrayList;

public class Jogador extends Tabuleiro{
    private Tabuleiro meu_tabuleiro;
    private ArrayList<Jogada> minhas_jogadas;
    
    public Jogador(){
        this.meu_tabuleiro = new Tabuleiro();
        this.minhas_jogadas = new ArrayList<>();
    }
    
    public void addJogadas(int linha, String coluna){
        Jogada auxiliar = new Jogada(linha,coluna);
        this.minhas_jogadas.add(auxiliar);
    }
    
    public ArrayList<Jogada> getMinhasJogadas(){
        return this.minhas_jogadas;
    }
    
    
    
}
