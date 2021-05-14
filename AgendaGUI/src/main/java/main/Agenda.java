package main;

import java.util.HashMap;
import java.util.Set;
import textFilesApps.CreateTextFile;

public class Agenda {
    private HashMap<String,Pessoa> agenda;

    public Agenda() {
        this.agenda = new HashMap<>();
    }

    public HashMap<String, Pessoa> getAgenda() {
        return agenda;
    }

    public void setAgenda(HashMap<String, Pessoa> agenda) {
        this.agenda = agenda;
    }

    public boolean inserirContato(Pessoa contato) {
        if(contato.getNome().equals("")){ 
            return false;
        }
        else if(contato.getTelefone().equals("")){
            return false;
        }
        else if(contato.getEndereco().equals("")){
            return false;
        }
        else if(contato.getEmail().equals("")){
            return false;
        }
        Set<String> keys = this.getAgenda().keySet();
        for(String chave: keys){ 
            if(contato.getNome().equals(this.getAgenda().get(chave).getNome())){
                this.getAgenda().get(chave).setNome(contato.getNome());
                this.getAgenda().get(chave).setTelefone(contato.getTelefone());
                this.getAgenda().get(chave).setEndereco(contato.getEndereco());
                this.getAgenda().get(chave).setEmail(contato.getEmail());
                return true;
            }
        }
        
        this.getAgenda().put(contato.getTelefone(), contato);
        return true;
    }

    public void gravar() {
        Set<String> chaves = this.getAgenda().keySet();
        for(String chave: chaves){
            CreateTextFile.addRecords(this.getAgenda().get(chave)); 
        }
    }

    public Pessoa pesquisar(String nome) {
            Pessoa contato = new Pessoa();
            Set<String> chaves = this.getAgenda().keySet();
            for(String chave: chaves){
                if(this.getAgenda().get(chave).getNome().startsWith(nome)){ 
                    return this.getAgenda().get(chave);
                }
                if(this.getAgenda().get(chave).getNome().equals(nome)){ 
                    return this.getAgenda().get(chave);
                }
            }
            return contato;
    }
    
    public void apagarContato(Pessoa x){
        this.getAgenda().remove(x.getTelefone());
    }
}