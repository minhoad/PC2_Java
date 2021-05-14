//Alunos: Darmes Dias e Alex Meireles
package batalha_DarmesDias_AlexMeireles;

public class Jogada {
    private final String[] nomeColuna = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
    private int linha;
    private int coluna;
    
    public Jogada(){
        
    }
    
    public Jogada(int linha, String coluna){
        this.linha = linha;
        for(int i = 0; i<13 ; i++){
            if(coluna.toUpperCase().equals(this.nomeColuna[i])){
                this.coluna = i;
            }
        } 
    }
    
    public void setLinha(int linha){
        this.linha = linha;
    }
    
    public void setColuna(String coluna){
        for(int i = 0; i<13 ; i++){
            if(coluna.toUpperCase().equals(this.nomeColuna[i])){
                this.coluna = i;
            }
        }
    }
    
    public int getLinha(){
        return this.linha;
    }
    
    public int getColuna(){
        return this.coluna;
    }
    
    
}
