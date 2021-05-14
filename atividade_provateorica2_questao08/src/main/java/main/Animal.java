package main;

public abstract class Animal implements AnimalOrcamento {
    private ItemOrcamentoComplexo meuOrcamentoMensal;
    
    @Override
    public ItemOrcamentoComplexo orcamentoGastosAnimal(String descricao, double valor){
        this.meuOrcamentoMensal = new ItemOrcamentoComplexo(descricao,valor);
        return this.meuOrcamentoMensal;
    }
    
    public ItemOrcamentoComplexo get_meuOrcamentoMensal(){
        return this.meuOrcamentoMensal;
    }
}
