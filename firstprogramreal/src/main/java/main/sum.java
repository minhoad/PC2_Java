package main;

import java.util.Scanner;

public class sum {
    public static void main(String[] args){
        Scanner Input = new Scanner(System.in);
        int n1,n2,sum;
        System.out.println("Digite o primeiro número: ");
        n1 = Input.nextInt();
        System.out.println("Digite o segundo número: ");
        n2 = Input.nextInt();
        sum = n1+n2;
        System.out.printf("%d + %d = %d", n1,n2,sum);
        
    }
}
