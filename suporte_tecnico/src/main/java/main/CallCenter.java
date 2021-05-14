// Aluno: Darmes Araujo Dias

package main;

import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true; // servirá para sair do loop se o cliente quiser sair do menu
        SuporteTecnico ti = new SuporteTecnico();
        Interpretadora interpretadora = new Interpretadora();
        System.out.println("\nBem-vindo ao sistema de Suporte Técnico.");
        while(flag){
            System.out.println("\nPressione <enter> para continuar ou digite 'sair' para sair do sistema.");
            String escolha = sc.nextLine();
            if(!escolha.toLowerCase().equals("sair")){
                System.out.println("\nDescreva seu problema de maneira sucinta.\n");
                String problemaDoCliente = sc.nextLine();
                ti.buscaSolucao(interpretadora.retornaProblema(problemaDoCliente));
            }else{// caso o usuário queria sair
                flag = false;
            }
        }
        sc.close();
    }    
}
