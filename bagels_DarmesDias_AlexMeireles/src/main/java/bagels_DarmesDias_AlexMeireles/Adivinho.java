package bagels_DarmesDias_AlexMeireles;

public class Adivinho {
    String palpite;
    
    public Adivinho(){     
        this.palpite = "";
    }
    
    public Adivinho(String x){
        this.palpite = x;
    }
    
    public void setPalpite(String x){
        this.palpite = x;
    }
    public String getPalpite(){
        return this.palpite;
    }
    
}
