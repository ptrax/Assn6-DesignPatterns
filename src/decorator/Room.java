package decorator;

import builder.Beehive;

public class Room {
    int maxCapacity = 0;
    float health = 100;
    int currentFill = 0;
    Beehive hive = null;
    
    /**
     * Sets up the room with an initial max capacity.
     * @param capacity - The max capacity for the room
     */
    public void initRoom(Beehive hive, int capacity) {  
        this.hive = hive;
        this.maxCapacity = capacity;
    }
    
    /**
     * Inflicts a certain amount of damage on the room. If the health drops 
     * to 0 the room is flagged as destroyed. 
     * @param amount - Amount of damage to inflict on the room
     */
    public void damage(float amount) {
        health -= amount;
    }

    public void heal(float amount) {
        if (health < 100) {
            if((health + amount) > 100){
                health = 100;
            } else {
                health += amount;
            }
        }
    }

    public float getHealth() {
        return health;
    }

    public String getType() {
        return "spawn";
    }

    public int getMaxCapacity() {
        return 0;
    }

    public int getCurrentFill() {
        return currentFill;
    }

    public int fillRoom(int num) {
        int overflow = 0;
        
        if(currentFill < maxCapacity){
            if ((currentFill + num) > maxCapacity) {
                overflow = (currentFill + num) - maxCapacity;
                currentFill = maxCapacity;
                
            } else {
                currentFill += num;
            }
        }
        
        return overflow;
    }

}
