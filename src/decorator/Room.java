package decorator;

import builder.Beehive;
import mediator.Mediator;

public interface Room extends Mediator {

    /**
     * Sets up the room with an initial max capacity.
     * @param capacity - The max capacity for the room
     */
    public void initRoom(Beehive hive, int capacity);
    
    /**
     * Inflicts a certain amount of damage on the room. If the health drops 
     * to 0 the room is flagged as destroyed. 
     * @param amount - Amount of damage to inflict on the room
     */
    public void damage(float amount);

    public void heal(float amount);

    public float getHealth();

    public String getType();

    public int getMaxCapacity();

    public int getCurrentFill();

    public int fillRoom(int num);

}
