package main;

public abstract class Tridimensional implements Forma {
    private int numFaces;
    
    public Tridimensional(){
        this.numFaces=0;
    }
    
    public Tridimensional(int x){
        this.numFaces = x;
    }

    public void setNumFaces(int x){
        this.numFaces = x;
    }
    
    public int getNumFaces(){
        return this.numFaces;
    }
    
    public abstract double obterVolume();
}
