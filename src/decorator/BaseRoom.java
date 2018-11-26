package decorator;

import builder.Beehive;
import mediator.Colleague;

/**
 * Basic room class holding the concrete implementation of the Room interface.
 * This provides methods for initializing a room, inflict damage, add health,
 * fill the room, and getters and setters. This is the class that gets 
 * decorated by the Food, Spawn, and Rest rooms. 
 * @author Paul Traxler
 *
 */
public class BaseRoom implements Room {

    int maxCapacity = 0;
    double health = 100;
    int currentFill = 0;
    Beehive hive = null;
    
    /**
     *  Basic constructor for setting the hive and demonstration.
     */
    public BaseRoom(Beehive hive) {
        this.hive = hive;
        System.out.println("New Basic Room created");
    }
    
    /**
     * Inflicts a certain amount of damage on the room. If the health drops 
     * below 0 it is capped and brought back up to 0.
     * @param amount - Amount of damage to inflict on the room
     */
    public void damage(double amount) {
        health -= amount / this.hive.getDefenseMultiplier();
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Heals the room a given amount. If the amount puts the room over 100 
     * health it is capped at 100.
     * 
     * @param amount - Amount of health to be applied.
     */
    public void heal(double amount) {
        if (health < 100) {
            if ((health + amount) > 100) {
                health = 100;
            } else {
                health += amount;
            }
        }
    }

    /**
     * Returns the amount of health the room has.
     */
    public double getHealth() {
        return health;
    }

    /**
     * Returns the type of room.
     */
    public String getType() {
        return "Base room";
    }

    /**
     * Returns the maximum capcity of the room.
     */
    public int getMaxCapacity() {
        return 0;
    }

    /**
     * Returns how full the room currently is.
     */
    public int getCurrentFill() {
        return currentFill;
    }

    /**
     * Fills the room a specified amount. If the room reaches max capacity it will
     * not allow an over fill, but instead return the number of overflow that occured
     * on fill attempt. 
     * 
     * @return Overflow, number of items that couldn't be added. 
     */
    public int fillRoom(int num) {
        int overflow = 0;
        
        if (currentFill < maxCapacity) {
            if ((currentFill + num) > maxCapacity) {
                overflow = (currentFill + num) - maxCapacity;
                currentFill = maxCapacity;
                
            } else {
                currentFill += num;
            }
        }
        
        return overflow;
    }

    /**
     * Receives a message. 
     * @param message - message to receive. 
     */
    public void receive(String message) {
        
    }

    /**
     * Sends a message to the mediator.
     * @param message - message to send.
     * @param coll - Colleague sending the message.
     */
    public void send(String message, Colleague coll) {
        // TODO Auto-generated method stub
        
    }
}
