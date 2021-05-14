package main;

import java.util.HashMap;
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class SuporteTecnico {
    private HashMap<String, String> bancoSolucao;
    private ArrayList<String> respostaPadrao;
    
    public SuporteTecnico(){
        this.bancoSolucao = new HashMap<>();
        this.respostaPadrao = new ArrayList<>();
        this.addCamposSolucao();
        this.addCamposRespostas();
    }
    public void setbancoSolucao(HashMap<String , String> x){
        this.bancoSolucao = x;
    }
    public void setrespostaPadrao(ArrayList<String> x){
        this.respostaPadrao = x;
    }
    public HashMap<String, String> getbancoSolucao(){
        return this.bancoSolucao;
    }
    public ArrayList<String> getrespostaPadrao(){
        return this.respostaPadrao;
    }
    
    private void addCamposSolucao(){
        this.getbancoSolucao().put("lento", "Penso que o problema está relacionado com o hardware. Fazer um upgrade\\n do seu processador deve resolver o problema de performance. Você tem algum\\n problema com o software?");
        this.getbancoSolucao().put("performance", "A performance está próxima do esperado nos testes que realizamos. Você está\\n executando algum outro processo em paralelo?");
        this.getbancoSolucao().put("bug","Bom, você sabe, todo software pode ter algum problema. Mas nossos engenheiros de software\n já estão atuando no problema para solucioná-lo. Você poderia descrever seu problema\n com mais detalhes?");
        this.getbancoSolucao().put("buggy", "Bom, você sabe, todo software pode ter algum problema. Mas nossos engenheiros de software\n já estão atuando no problema para solucioná-lo. Você poderia descrever seu problema\n com mais detalhes?");
        this.getbancoSolucao().put("windows", "Este é um problema do sistema operacional Windows. Por favor, \n entre em contato com a Microsoft. Não há nada que possamos fazer neste caso.");
        this.getbancoSolucao().put("macintosh", "Este é um problema do sistema operacional Mac. Por favor, \n entre em contato com a Apple. Não há nada que possamos fazer neste caso.");
        this.getbancoSolucao().put("caro", "O preço do nosso produto é competitivo. Você já fez uma pesquisa de mercado\n e comparou todas as características do nosso software com outras ofertas de mercado?");
        this.getbancoSolucao().put("instalação","A instalação é simples e direta. Nós temos programas de instalação previamente configurados\n que farão todo o trabalho para você. Você já leu as instruções\n de instalação?");
        this.getbancoSolucao().put("memória", "Se você observar detalhadamente os requisitos mínimos de sistema, você verá que\n a memória requerida é 1.5 giga byte. Você deverá adquirir\n mais memória. Mais alguma coisa que deseja saber?");
        this.getbancoSolucao().put("linux", "Nós consideramos seriamente o suporte Linux. Mas existem muitos problemas.\n Muitos deles dizem respeito a versões incompatíveis. Você poderia ser\n mais preciso?");                                                 
        this.getbancoSolucao().put("danificaram", "Bom, nosso software não danificaria seu sistema. Deve ser algo específico\n no seu sistema. Diga-me sobre sua configuração.");
        this.getbancoSolucao().put("danificou", "Bom, nosso software não danificaria seu sistema. Deve ser algo específico\n no seu sistema. Diga-me sobre sua configuração.");
    }
    private void addCamposRespostas(){
        this.getrespostaPadrao().add("Isso soa estranho. Você poderia descrever o problema com mais detalhes?");
        this.getrespostaPadrao().add("Nenhum outro cliente detalhou um problema parecido com este. \n Qual é a sua configuração de sistema?");
        this.getrespostaPadrao().add("Isso parece interessante. Diga-me mais a respeito...");
        this.getrespostaPadrao().add("Preciso de maiores informações a respeito.");
        this.getrespostaPadrao().add("Você já verificou se existe algum conflito de DLL?");
        this.getrespostaPadrao().add("Isso está descrito no manual. Você já deu uma lida no manual que veio junto do seu software?");
        this.getrespostaPadrao().add("Sua descrição não foi satisfatória. Você já procurou um técnico\n que poderia detalhar melhor este problema?");
        this.getrespostaPadrao().add("Isso não é um problema, é apenas uma característica do software!");
        this.getrespostaPadrao().add("Você poderia explicar melhor?");
    }
    
    public void buscaSolucao(HashSet<String> x){
        Set<String> keys = this.bancoSolucao.keySet(); // pega todas as keys do HashMap bancoSolucao
        String problema = null;
        for(String key : keys){ 
            for(String problemas: x){   
                if(key.equals(problemas)){ // compara cada key com cada palavra  do HashSet
                    problema = this.bancoSolucao.get(key); // caso encontrar a palvra chave atribui ela a string problema
                }
            }
        }
        if(problema!=null){ // caso ache a palavra chave no HashMap
            System.out.printf("%s",problema);
        }else{ // caso não ache, e tenha que dar uma solução padrão
            buscaSolucaoPadrao();
        }
    }
    
    private void buscaSolucaoPadrao(){
        SecureRandom randomizador = new SecureRandom();
        int random = randomizador.nextInt(this.respostaPadrao.size());
        System.out.printf("%s",this.respostaPadrao.get(random));
    }
}
