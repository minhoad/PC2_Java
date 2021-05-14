package main;

public class Triangulo extends Bidimensional {
    private double base;
    private double altura;
    
    public Triangulo(){
        super(3);
        this.base = 0;
        this.altura = 0;
    }
    public Triangulo(double x, double y){
        super(3);
        this.base = x;
        this.altura = y;
    }
    public void setBase(double x){
        this.base = x;
    }
    public void setAltura(double x){
        this.altura = x;
    }
    public double getBase(){
        return this.base;
    }
    public double getAltura(){
        return this.altura;
    }
    @Override
    public double obterArea() {
        return ((this.getBase()*this.getAltura())/2);
    }
    
}
