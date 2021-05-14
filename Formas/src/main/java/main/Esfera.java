package main;

public class Esfera extends Tridimensional{
    private double raio;
    
    public Esfera(){
        super(1);
        this.raio = 0;
    }
    public Esfera(double x){
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
        return (4*(Math.PI*(this.getRaio()*this.getRaio())));
    }
    @Override
    public double obterVolume() {
        return ((4*(Math.PI*(this.getRaio()*(this.getRaio()*this.getRaio()))))/3);
    }    
}
