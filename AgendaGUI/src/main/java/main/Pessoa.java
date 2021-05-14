package main;

public class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Pessoa() {
        super();
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.email = "";
    }

    public Pessoa(String nome, String endereco, String telefone, String email) {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}