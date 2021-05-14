// Darmes Araujo Dias
package main;

public class Inventario {
    public static void main(String[] args) {
        Situacao p1 = new Situacao();
        Situacao p2 = new Situacao();
        p1.addBens(new Seguidor(1000,2));
        p1.addBens(new Moeda(1000,3));
        p1.addBens(new Recurso(5,6));
        p1.addBens(new Ferramenta(1000,"defesa"));
        p1.addBens(new Cenario(10,5,7));
        p1.addBens(new Vida(3,"01/08/2021"));
        p2.addBens(new Seguidor(2000,3));
        p2.addBens(new Moeda(500,2));
        p2.addBens(new Recurso(7,1));
        p2.addBens(new Ferramenta(1000,"invisibilidade"));
        p2.addBens(new Cenario(100,4,8));
        p2.addBens(new Vida(7,"01/01/2021"));
        System.out.println("Inventário P1:"+p1.calculaValorInventario());
        System.out.println("Inventário P2:"+p2.calculaValorInventario());
    }
}
