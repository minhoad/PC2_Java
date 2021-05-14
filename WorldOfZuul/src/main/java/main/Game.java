//Darmes Dias
package main;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Room> rooms;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        rooms = new ArrayList<Room>();
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office, porao, sotao;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        porao = new Room("in the porão");
        sotao = new Room("in the sotão");
        
        // initialise room exits
        outside.setExits(null, theatre, lab, pub, null, null);
        theatre.setExits(null, null, null, outside, null, null);
        pub.setExits(null, outside, null, null, null, null);
        lab.setExits(outside, office, null, null, null, null);
        office.setExits(null, null, null, lab, sotao, porao);
        porao.setExits(null, null, null,null, office, null);
        sotao.setExits(null, null, null,null, null, office);

        outside.setItens("sacola","embalagem de biscoito",null);
        theatre.setItens("livro preto misterioso","caderno velho", "celular");
        pub.setItens("garrafa quebrada",null,null);
        lab.setItens("notebook escondido","papel com números anotados", null);
        office.setItens("registros de alunos","caneca de café com simbolo do pt","chave");
        porao.setItens("baú","jornais velhos", null);
        sotao.setItens("manequim", null,null);
        
        rooms.add(outside);
        rooms.add(theatre);
        rooms.add(pub);
        rooms.add(lab);
        rooms.add(office);
        rooms.add(porao);
        rooms.add(sotao);
        
        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command;
			command = parser.getCommand();
                        finished = processCommand(command);  
        }
        System.out.println(MessageJavaFx.QUIT);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(MessageJavaFx.WELCOME);
        System.out.println(MessageJavaFx.DESCRIPTION_OF_GAME);
        System.out.println(MessageJavaFx.HELP_COMMAND);
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.println("Itens:");
        for(String x:currentRoom.getItens()){
            System.out.println(x);
        }
        System.out.print("Exits: ");
        if(currentRoom.directions.containsKey("north"))
            System.out.print("north ");
        if(currentRoom.directions.containsKey("east"))
            System.out.print("east ");
        if(currentRoom.directions.containsKey("south"))
            System.out.print("south ");
        if(currentRoom.directions.containsKey("west"))
            System.out.print("west ");
        if(currentRoom.directions.containsKey("up"))
            System.out.print("up ");
        if(currentRoom.directions.containsKey("down"))
            System.out.print("down ");
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
/*
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
*/
        String commandWord = "";
        try{
            commandWord = command.getCommandWord();
        }
        catch(InvalidCommandException ex){
            System.err.println(ex.getMessage());
        }
        
        if (commandWord.equals("help"))
        CommandWords.printHelp();
        else if (commandWord.equals("go"))
            goRoom(command,false);
        else if (commandWord.equals("procurar"))
            procurar();
        else if (commandWord.equals("comer"))
            comer();
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);
        
        
        
        
        
        return wantToQuit;
    }
    
    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command, boolean procurar) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
     
        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals("north")){
            nextRoom = currentRoom.directions.get("north");
        }
        if(direction.equals("east")){
            nextRoom = currentRoom.directions.get("east");
        }
        if(direction.equals("south")){
            nextRoom = currentRoom.directions.get("south");
        }
        if(direction.equals("west")){
            nextRoom = currentRoom.directions.get("west");
        }
        if(direction.equals("up")){
            nextRoom = currentRoom.directions.get("up");
        }
        if(direction.equals("down")){
            nextRoom = currentRoom.directions.get("down");
        }
        

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            currentRoom = nextRoom;
            if(!procurar)
                System.out.println("You are " + currentRoom.getDescription());
            System.out.println("Itens:");
            for(String x:currentRoom.getItens()){
                System.out.println(x);
            }
            System.out.print("Exits: ");
            if(currentRoom.directions.containsKey("north"))  
                System.out.print("north ");
            if(currentRoom.directions.containsKey("east"))  
                System.out.print("east ");
            if(currentRoom.directions.containsKey("south"))  
                System.out.print("south ");
            if(currentRoom.directions.containsKey("west"))  
                System.out.print("west ");
            if(currentRoom.directions.containsKey("up"))  
                System.out.print("up ");
            if(currentRoom.directions.containsKey("down"))  
                System.out.print("down ");
            System.out.println();
            
        }
        
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else
            return true;  // signal that we want to quit
    }
    
    private void procurar(){
        Scanner in = new Scanner(System.in);
        System.out.println("-----Aba de procura-----");
        System.out.println("Digite o nome da sala: ");
        String aux = in.nextLine();
        if(aux.toLowerCase().equals("computing lab")){
            System.out.println(MessageJavaFx.LOCAL_LAB);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(3).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(3).getHash().keySet()){
                System.out.println(x);
            }
        }
        if(aux.toLowerCase().equals("computing admin office")){
            System.out.println(MessageJavaFx.LOCAL_OFFICE);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(4).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(4).getHash().keySet()){
                System.out.println(x);
            }
        }
        if(aux.toLowerCase().equals("campus pub")){
            System.out.println(MessageJavaFx.LOCAL_PUB);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(2).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(2).getHash().keySet()){
                System.out.println(x);
            }
        }
        if(aux.toLowerCase().equals("lecture theatre")){
            System.out.println(MessageJavaFx.LOCAL_THEATRE);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(1).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(1).getHash().keySet()){
                System.out.println(x);
            }
        }
        if(aux.toLowerCase().equals("porao")){
            System.out.println(MessageJavaFx.LOCAL_PORAO);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(5).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(5).getHash().keySet()){
                System.out.println(x);
            }
        }
        if(aux.toLowerCase().equals("sotao")){
            System.out.println(MessageJavaFx.LOCAL_SOTAO);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(6).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(6).getHash().keySet()){
                System.out.println(x);
            }
        }
        if(aux.toLowerCase().equals("outside")){
            System.out.println(MessageJavaFx.LOCAL_ENTRANCE);
            System.out.println(MessageJavaFx.itens);
            for(String x:rooms.get(0).getItens()){
                System.out.println(x);
            }
            System.out.println(MessageJavaFx.saidas);
            for(String x:rooms.get(0).getHash().keySet()){
                System.out.println(x);
            }
        }
        System.out.println("-------------------------");
           
    }
    
    
    private void comer(){
        System.out.println(MessageJavaFx.mensagem_comer);
    }
}
