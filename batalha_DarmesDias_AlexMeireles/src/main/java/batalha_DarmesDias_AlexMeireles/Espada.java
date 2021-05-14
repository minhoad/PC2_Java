//Alunos: Darmes Dias e Alex Meireles
package batalha_DarmesDias_AlexMeireles;

public class Espada {
    private String descricao;
    private int valor;
    
    public Espada(String descricao, int valor){
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getValor(){
        return this.valor;
    }
    
}
