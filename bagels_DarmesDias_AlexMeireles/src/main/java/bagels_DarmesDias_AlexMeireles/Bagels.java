// Alunos: Darmes Araujo Dias, Alex Meireles Santos Almeida
package bagels_DarmesDias_AlexMeireles;

import java.util.Scanner;

public class Bagels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true; // Váriavel para tornar o loop verdadeiro, até a condição sair do loop(break)
        int numero_de_palpites,contador_de_palpites=0;
        float porcentagem_de_acertos=0,aux_contador_de_palpites=0;
        String auxiliar_de_numero_escolhido = "";
        System.out.println("Digite o número de palpites:");
        numero_de_palpites = sc.nextInt();
        sc.nextLine();
        while(flag){      // Garante que o número escolhido pelo Desafiador não tenha números repetidos   
            System.out.println("Digite o número escolhido:");
            auxiliar_de_numero_escolhido = sc.nextLine();
            if(!numerosRepetidos(auxiliar_de_numero_escolhido)){
                break;
            }else{
                System.out.println("Você digitou digitos repetidos.");
            }
        }
        Desafiador Alex = new Desafiador(auxiliar_de_numero_escolhido);
        Adivinho Darmes = new Adivinho();
        while(flag){ 
            System.out.println("Digite seu palpite:");
            String auxiliar_de_palpite = sc.nextLine();
            if(!numerosRepetidos(auxiliar_de_palpite)){
                contador_de_palpites++;// Garante que o palpite dado pelo Adivinho não tenha números repetidos 
                Darmes.setPalpite(auxiliar_de_palpite);
                Alex.setResultado(Darmes.getPalpite());
                System.out.println(Alex.getResultado());              
                if(Alex.getResultado().equals("Fermi Fermi Fermi")||contador_de_palpites==numero_de_palpites){
                    break;
                }
                Alex.resetResultado();// Reseta o membro resultado para settar ele novamente 
            }else{
                System.out.println("Você digitou digitos repetidos.");
                continue;
            }
        }
        aux_contador_de_palpites = contador_de_palpites; // PARA GARANTIR QUE A OPERAÇÃO ABAIXO SEJA FLOAT
        if(Alex.getResultado().equals("Fermi Fermi Fermi")){ // SE TIVER ACERTADO AI VAI SER !=0, PORQUE É INICIALIZADO COMO 0
            porcentagem_de_acertos = (1/aux_contador_de_palpites)*100;
        }
        System.out.println(porcentagem_de_acertos + " por cento de acerto nos palpites.");
        sc.close();
    }
    
    static boolean numerosRepetidos(String x){ // método para verificar se existem números repetidos
        char []aux = x.toCharArray();
        for(int i = 0;i < aux.length ; i++){
            for(int j = 0;j<aux.length ; j++){
                if(aux[i]==aux[j] && i!=j){
                    return true; // possui numeros repetidos
                }
            }
        }
        return false; // nao possui numero repetidos
    }
}
