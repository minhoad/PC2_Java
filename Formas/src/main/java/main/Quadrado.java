package main;

public class Quadrado extends Bidimensional{
    public double lados;
    public Quadrado(){
        super(4);
        this.lados = 0;
    }
    public Quadrado(double x){
        super(4);
        this.lados = x;
    }
    public void setLados(double x){
        this.lados = x;
    }
    public double getLados(){
        return this.lados;
    }
    @Override
    public double obterArea() {
       return (this.getLados()*this.getLados());
    }
}
