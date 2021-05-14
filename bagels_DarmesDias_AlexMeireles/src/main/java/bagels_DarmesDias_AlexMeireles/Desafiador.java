package bagels_DarmesDias_AlexMeireles;

public class Desafiador {
    String numero_escolhido;
    String resultado;
    
    public Desafiador(){
        this.numero_escolhido = "";
        this.resultado = "";
    }
    
    public Desafiador(String x){
        this.numero_escolhido = x;
        this.resultado = "";
    }
    
    public void setResultado(String x){
        int contador_para_condicao_bagels=0;
        boolean [] posicao_certa = new boolean[3];// Usado para ver se os números são certos e estão na posição certa
        boolean [] numeros_certos = new boolean[3];//Usado para ver se os números são certos mas não estão na posição certa
        for(int o=0;o<posicao_certa.length;o++){// PREENCHENDO TODAS AS POSIÇÕES DO VETOR COM FALSE
            posicao_certa[o]=false;
            numeros_certos[o]=false;
        } 
        if(x.equals(this.numero_escolhido)){ // compara se já tiver acertado
            this.resultado = "Fermi Fermi Fermi";
        }
        else{
            char [] n_escolhido = this.numero_escolhido.toCharArray();
            char [] palpite = x.toCharArray(); // Passo pra array de char para poder comparar melhor
            for(int i = 0 ; i<n_escolhido.length ; i++){
                for(int j = 0 ; j<n_escolhido.length ; j++){
                    if(n_escolhido[i] == palpite[j] && i!=j){
                        numeros_certos[i]=true;
                    }
                    if(n_escolhido[i] == palpite[j] && i==j){
                        posicao_certa[i]=true;
                    }
                }
            }
            for(int i=0;i<3;i++){
                if(numeros_certos[i]==true){
                    this.resultado+="Pico ";
                }
            }
            for(int i=0;i<3;i++){
                if(posicao_certa[i]==true){
                        this.resultado+="Fermi ";
                    }
            }
            for(int i=0;i<3;i++){
                if(posicao_certa[i]==false && numeros_certos[i]==false){
                    contador_para_condicao_bagels++;
                }
            }
            if(contador_para_condicao_bagels==3){ // Caso nenhuma das matrizes seja preenchida com true
                this.resultado="Bagels";
            }
        }
        
    }
    
    public String getResultado(){
        return this.resultado;
    }
    public void resetResultado(){ // resetta resultado porque cada palpite é uma nova invocação
        this.resultado="";        // do método setResultado
    }
}
