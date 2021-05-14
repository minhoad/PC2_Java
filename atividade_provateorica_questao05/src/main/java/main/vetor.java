package main;

import java.security.SecureRandom;

public class vetor {
    public int[] vect = {0,0,0,0,0,0,0,0,0,0};
    
    
    public void add(int vect[]) {
        int contador =0;
        SecureRandom sr = new SecureRandom();
            while(contador<4) {
                for(int i=0;i<10;i++) {
                    if(i%2==0){
                        vect[i]=sr.nextInt(10);
                    }
                }             
                contador++;
            }
        
    }
    public void comparar(int vect[]) {
                add(vect);
		int aux;
		aux = vect[0];
		for (int j = 0; j < 10; j++) {
			if (aux < vect[j]) {
				aux = vect[j];
			}
		}
                int[] posicoes = {-1,-1,-1,-1,-1}; // 5 é o maximo 
                int k=0;// contador
                for (int j = 0; j < 10; j++) {
			if (aux == vect[j]) {
				posicoes[k] = j; // colocando a posição no vetor 
                                k++;
			}
		}
                System.out.println("O maior número apareceu na(s) posição(ões): ");
                for(int z=0;z<5;z++){
                    if(posicoes[z] != -1){
                        System.out.printf("%d  ", posicoes[z]);
                    }
                }
                System.out.println("\n");
                System.out.printf("O maior número é: %d",aux);
		
    }
            
       
}



