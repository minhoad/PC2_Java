package textFilesApps;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import main.Pessoa;

public class CreateTextFile {
    private static Formatter output; 
    
    public static void openFile() {
        try {
            output = new Formatter("agenda.txt"); 
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); 
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); 
        }
    }
    public static void addRecords(Pessoa contato) {
        try {
            output.format("%s;%s;%s;%s\n", contato.getNome(),
                    contato.getTelefone(), contato.getEndereco(), contato.getEmail());
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Erro ao escrever no arquivo. Finalizando.");
        } catch (NoSuchElementException elementException) {
            System.err.println("Entrada inválida. Tente novamente!");
        }
    }

    public static void closeFile() {
        if (output != null) {
            output.close();
        }
    }
} 