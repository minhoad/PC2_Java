//Darmes Dias
package main;

import java.util.HashMap;
import java.util.ArrayList;


/*
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Room 
{
    public String description;
    public HashMap<String,Room> directions;
    private ArrayList<String> itens;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Room(String description) 
    {
        this.description = description;
        this.directions = new HashMap<String,Room>();
        this.itens = new ArrayList<String>();
        
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) 
    {
        if(north != null)
            this.directions.put("north",north);
        
        
        if(east != null)
            this.directions.put("east",east);
       
        
        if(south != null)
            this.directions.put("south",south);
       
        
        if(west != null)
            this.directions.put("west",west);
        
        
        if(up != null)
            this.directions.put("up",up);
        
        
        if(down != null)
            this.directions.put("down",down);
        
    }

    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }

    public void addItens(String y){
        this.itens.add(y);
    }
    
    public void setItens(String x, String y, String z){
        if(x!=null)this.addItens(x);
        if(y!=null)this.addItens(y);
        if(z!=null)this.addItens(z);
    }
    
    public ArrayList<String> getItens(){
        return this.itens;
    }
    public HashMap<String, Room> getHash(){
        return this.directions;
    }
}
