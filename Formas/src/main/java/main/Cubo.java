package main;

public class Cubo extends Tridimensional{
    private double aresta;
    
    public Cubo(){
        super(6);
        this.aresta = 0;
    }
    public Cubo(double x){
        super(6);
        this.aresta = x;
    }
    public void setAresta(double x){
        this.aresta = x;
    }
    public double getAresta(){
        return this.aresta;
    }
    @Override
    public double obterArea() {
        return (6*(this.getAresta()*this.getAresta()));
    }
    @Override
    public double obterVolume() {
        return ((this.getAresta()*this.getAresta())*this.getAresta());
    }
}
