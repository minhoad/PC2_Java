package main;

public abstract class Bidimensional implements Forma {
    private int numLados;
    
    
    public Bidimensional(){
        this.numLados=0;
       
    }
    
    public Bidimensional(int x){
        this.numLados = x;
        
    }
    
    public void setNumLados(int x){
        this.numLados = x;
    }
    
    public int getNumLados(){
        return this.numLados;
    }
    
}
