package main;

import java.util.ArrayList;

public class CaixaDeBrinquedo {
    private ArrayList<Forma> lista_de_formas;
    
    public CaixaDeBrinquedo(){
        this.lista_de_formas = new ArrayList<>();
    }
    
    public void addLista(Forma x){
        this.lista_de_formas.add(x);
    }
    // Observação o volume é cúbico, logo será maior que a área
    // Eu não especifiquei a unidade de medida, por isso no exemplo do cubo e no tetraedro
    // parece que é maior, mas não é.
    public void trataFormas(){
        for(Forma auxiliar:lista_de_formas){
            if(auxiliar instanceof Bidimensional){
                if(((Bidimensional)auxiliar).getNumLados()==3){
                    System.out.println("Eu sou um triângulo e a minha área é "+((Bidimensional)auxiliar).obterArea());
                }
                else if(((Bidimensional)auxiliar).getNumLados()==4){
                    System.out.println("Eu sou um quadrado e a minha área é "+((Bidimensional)auxiliar).obterArea());
                }
                else if((((Bidimensional)auxiliar).getNumLados()==1)){
                    System.out.println("Eu sou um circulo e a minha área é "+((Bidimensional)auxiliar).obterArea());
                }
            }
            else if(auxiliar instanceof Tridimensional){
                if(((Tridimensional)auxiliar).getNumFaces()==4){
                    System.out.println("Eu sou um tetraedro e a minha área é "+((Tridimensional)auxiliar).obterArea()+" e o meu volume é "+((Tridimensional)auxiliar).obterVolume());
                }
                else if(((Tridimensional)auxiliar).getNumFaces()==6){
                    System.out.println("Eu sou um cubo e a minha área é "+((Tridimensional)auxiliar).obterArea()+" e o meu volume é "+((Tridimensional)auxiliar).obterVolume());
                }
                else if((((Tridimensional)auxiliar).getNumFaces()==1)){
                    System.out.println("Eu sou uma esfera e a minha área é "+((Tridimensional)auxiliar).obterArea()+" e o meu volume é "+((Tridimensional)auxiliar).obterVolume());
                }
            }
        }
    }
}
