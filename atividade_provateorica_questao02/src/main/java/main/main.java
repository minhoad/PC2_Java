/*Alunos: Darmes Dias, Alex Meireles*/

package main;


public class main {
    public static void main(String[] args){
        EquacaoSegundoGrau obj = new EquacaoSegundoGrau(3,-2,-8);
        System.out.println(obj.raiz1);
        System.out.println(obj.raiz2);
    }
}
//A complexidade é criar um objeto toda vez que for usar a classe, com isso usaria mais memória.
//A vantagem é o encapsulamento, de uma maneira mais interessante e também na hora de exportar.
