//Darmes Dias
package main;
/*
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class CommandWords
{
    // a constant array that holds all valid command words
    private static final String validCommands[] = {
        "go", "quit", "help", "look", "procurar", "comer"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * Return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }

        // if we get here, the string was not found in the commands
        return false;
    }
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public static void printHelp() 
    {
        System.out.println(MessageJavaFx.YOUR_STATUS);
        System.out.println(MessageJavaFx.YOUR_LOCATE);
        System.out.println();
        System.out.println(MessageJavaFx.YOUR_COMMANDS);
        System.out.println(MessageJavaFx.YOUR_POSSIBILITY_OF_COMMANDS);
    }

    
    
}
