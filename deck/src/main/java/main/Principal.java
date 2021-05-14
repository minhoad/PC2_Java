package main;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Cards carta1 = new Cards();
        Cards carta2 = new Cards();
        System.out.println("Digite o valor da primeira carta: ");
        carta1.setValue(input.nextInt());
        System.out.println("Digite o valor da segunda carta: ");
        carta2.setValue(input.nextInt());
        System.out.println("Digite o naipe da primeira carta: ");
        carta1.setSuit(input.next());
        System.out.println("Digite o naipe da segunda carta: ");
        carta2.setSuit(input.next());
        System.out.println(carta1.isequalsuit(carta2)?"Naipe é igual":"Naipe é diferente"); 
        switch(carta1.comparison(carta2)){
            case 1:
                System.out.printf("A primeira carta(%d de %s) tem valor maior que a segunda(%d de %s)", carta1.getValue(),carta1.getSuit(),carta2.getValue(),carta2.getSuit());
                break;
            case -1:
                System.out.printf("A primeira carta(%d de %s) tem valor menor que a segunda(%d de %s)", carta1.getValue(),carta1.getSuit(),carta2.getValue(),carta2.getSuit());
                break;
            case 0:
                System.out.printf("A primeira carta(%d de %s) tem valor igual a segunda(%d de %s)", carta1.getValue(),carta1.getSuit(),carta2.getValue(),carta2.getSuit());
                break;
            // não possui caso default, pois não tem opção de não dar um dos 3 case's
        }
        input.close();
    }    
}