package main;

public class Circulo extends Bidimensional{
    private double raio;
    
    public Circulo(){
        super(1);
        this.raio = 0;
    }
    public Circulo(double x){
        super(1);
        this.raio = x;
    }    
    public void setRaio(double x){
        this.raio = x;
    }    
    public double getRaio(){
        return this.raio;
    }
    @Override
    public double obterArea() {
        return (Math.PI*(this.getRaio()*this.getRaio()));
    }
    
}
