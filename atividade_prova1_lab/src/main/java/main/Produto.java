package main;
/**
 * class Produto cria um objeto produto, que possui código, descrição e preco.
 * Dentro da classe, temos dois contrutores, um padrão e o outro que a gente "setta" os membros, e existem o set's e get's
 * de cada membro.
 * 
 * @author darmes
 */
public class Produto {
    private String codigo_do_produto;
    private String descricao;
    private float preco;
    
    public Produto(){
        this.codigo_do_produto = " ";
        this.descricao = " ";
        this.preco = 0;      
    }
    
    public Produto(String codigo, String descricao, float preco){
        this.codigo_do_produto = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public void setCodigo(String codigo){
        this.codigo_do_produto = codigo;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
    
    public String getCodigo(){
        return this.codigo_do_produto;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public float getPreco(){
        return this.preco;
    }
    
}
