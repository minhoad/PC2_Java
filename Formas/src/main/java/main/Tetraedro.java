package main;

public class Tetraedro extends Tridimensional{
    private double aresta;
    
    public Tetraedro(){
        super(4);
        this.aresta=0;
    }
    public Tetraedro(double x){
        super(4);
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
        return ((this.getAresta()*this.getAresta())*Math.sqrt(3));
    }
    @Override
    public double obterVolume() {
        return ((((this.getAresta()*this.getAresta())*Math.sqrt(3))/4)*((this.getAresta()*Math.sqrt(6))/3))/3;
    }
}
