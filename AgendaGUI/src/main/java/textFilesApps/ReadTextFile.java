package textFilesApps;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import main.Pessoa;

public class ReadTextFile {

    private static Scanner input;

    public static void openFile() {
        try {
            input = new Scanner(Paths.get("agenda.txt"));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static HashMap<String, Pessoa> readRecords() {
        HashMap<String, Pessoa> hashMapAux = new HashMap<>();
        
        try {
            while (input.hasNext()) 
            {    
                String linha = input.nextLine();
                String[] pedacosLinha = linha.split(";");
                
                String nome = "";
                String endereco = "";
                String telefone = "";
                String email = "";
        
                if(pedacosLinha[0]!=null){
                    nome = pedacosLinha[0];
                }
                if(pedacosLinha[0]!=null){
                    endereco = pedacosLinha[1];
                }
                if(pedacosLinha[0]!=null){
                    telefone = pedacosLinha[2];
                }
                if(pedacosLinha[0]!=null){
                    email = pedacosLinha[3];
                }
   
                Pessoa c = new Pessoa(nome, endereco, telefone, email);
                
                hashMapAux.put(c.getTelefone(), c);
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
        return hashMapAux;
    } 
   
    public static void closeFile() {
        if (input != null) {
            input.close();
        }
    }
} 