package main;


public class EquacaoSegundoGrau {
    public double raiz1;
    public double raiz2;
    
    public EquacaoSegundoGrau (double a,double b,double c){
        this.raiz1 = ((-b) + (Math.sqrt((b*b)- (4*a*c))))/(2*(a));
        this.raiz2 = ((-b) - (Math.sqrt((b*b)- (4*a*c))))/(2*(a));  
    }
}
