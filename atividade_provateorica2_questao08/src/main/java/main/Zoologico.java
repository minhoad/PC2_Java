package main;
import java.util.ArrayList;
import java.util.Scanner;

public class Zoologico{
    private ArrayList<AnimalOrcamento> lista_de_animais;
    
    public Zoologico(){
        this.lista_de_animais = new ArrayList<>();
    }
    
    public ArrayList<AnimalOrcamento> animaisComVacinaW(){
        ArrayList<AnimalOrcamento> orcamentos = new ArrayList<>();
        for(AnimalOrcamento o : this.lista_de_animais){
            Orcamento x = (Orcamento) o;
            for(String s: x.get_meuOrcamentoMensal().get_descricao_gastos_previstos()){
                if(s.equals("vacina W")){
                    orcamentos.add(o);
                }
            }   
        }
        return orcamentos;
    }   
    public void encherALista(){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0;i<3;i++){
            String a = sc.nextLine();
            Orcamento o = new Orcamento();
            o.orcamentoGastosAnimal(a, i);
            lista_de_animais.add(o);
        }
    }
    public static void main(String[] args) {
        Zoologico meu = new Zoologico();
        meu.encherALista();
        ArrayList<AnimalOrcamento> x = meu.animaisComVacinaW();
        for(AnimalOrcamento u:x ){
            Animal a = (Animal) u;
            a.get_meuOrcamentoMensal().print();
        }
    }
}
