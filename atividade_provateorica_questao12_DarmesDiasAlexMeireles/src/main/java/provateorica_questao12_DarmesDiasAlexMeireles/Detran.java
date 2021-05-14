package provateorica_questao12_DarmesDiasAlexMeireles;

import java.util.ArrayList;

public class Detran {
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Proprietario> proprietarios;
    
    public boolean adicionaProp(Proprietario prop){
        int pos = procuraProprietario(prop.getCpf());
        if(pos!=1){
            proprietarios.add(prop);
            return true;
        }
        return false;
    }
}
