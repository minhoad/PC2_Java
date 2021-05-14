//Alunos: Darmes Dias e Alex Meireles
package batalha_DarmesDias_AlexMeireles;

public class Tabuleiro {
    private Espada[][] tabuleiro;
    
    public Tabuleiro(){
        this.tabuleiro = new Espada[13][13];
        criarTabuleiro();
    }
    
    // Preenchendo o tabuleiro com null
    private void criarTabuleiro(){
        for(int i = 0; i<13 ; i++){
            for(int j = 0; j<13 ; j++){
                this.tabuleiro[i][j] = null;
            }
        }
    }
    // Posicionando no tabuleiro do jogador a espada escolhida por ele
    public void setTabuleiro(Jogada posicionando, Espada espada_posicionada){
        this.tabuleiro[posicionando.getLinha()][posicionando.getColuna()] = espada_posicionada;
    }
    
    public Espada[][] getTabuleiro(){
        return this.tabuleiro;
    }
    
    // Conferindo se o jogador adversário acertou a posição
    public boolean confereAcerto(Jogada jogada_realizada,Jogador x){
        
        if(x.getTabuleiro()[jogada_realizada.getLinha()][jogada_realizada.getColuna()]!=null){
            return true;
        }
        return false; 
    }
    
}
