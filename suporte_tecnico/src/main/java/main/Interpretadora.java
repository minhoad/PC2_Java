package main;

import java.util.HashSet;

public class Interpretadora {
    private HashSet<String> palavraChave;
    
    public Interpretadora(){
        this.palavraChave = new HashSet<>();
    }
    public HashSet<String> retornaProblema(String x){
        String[] palavras = x.split(" ");
        for(int i=0;i<palavras.length;i++){
            if(!(this.palavraChave.contains(palavras[i]))){// só adiciona um de cada palavra(verifica se já tem a palavra)
                this.palavraChave.add(palavras[i]); // colocando cada palavra no HashSet palavraChave
            }
        }
        return this.palavraChave; // retorna o HashSet com cada palavra separada
    }
    
}
