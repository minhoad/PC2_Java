// Darmes Araujo Dias

package main;

public class Teste {
    public static void main(String[] args) {
        CaixaDeBrinquedo formas = new CaixaDeBrinquedo();
        Forma triangulo_1 = new Triangulo(3,5);
        Forma quadrado_1 = new Quadrado(5);
        Forma circulo_1 = new Circulo(3);
        Forma tetraedro_1 = new Tetraedro(5);
        Forma cubo_1 = new Cubo(3);
        Forma esfera_1 = new Esfera(6);
        formas.addLista(triangulo_1);
        formas.addLista(quadrado_1);
        formas.addLista(circulo_1);
        formas.addLista(tetraedro_1);
        formas.addLista(cubo_1);
        formas.addLista(esfera_1);
        formas.trataFormas();
        
    }
}
