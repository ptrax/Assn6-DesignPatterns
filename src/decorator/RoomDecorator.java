package decorator;

import builder.Beehive;
import mediator.Colleague;
import mediator.Mediator;

public class RoomDecorator implements Room {
    protected Room room;
    
    int maxCapacity = 0;
    float health = 100;
    int currentFill = 0;
    Beehive hive = null;
    Mediator mediator = null;
    
    public RoomDecorator(Room room, Mediator m) {
        this.room = room;
        this.mediator = m;
    }
    
    public String getType() {
        return this.room.getType();
    }

    public void send(String message, Colleague coll) {
        this.room.send(message, coll);
    }

    public void initRoom(Beehive hive, int capacity) {
        this.room.initRoom(hive, capacity);
        
    }

    public void damage(float amount) {
        this.room.damage(amount);
        
    }

    public void heal(float amount) {
        this.room.heal(amount);        
    }

    public float getHealth() {
        return this.room.getHealth();
    }

    public int getMaxCapacity() {
        return this.room.getMaxCapacity();
    }

    public int getCurrentFill() {
        return this.room.getCurrentFill();
    }

    public int fillRoom(int num) {
        return this.room.fillRoom(num);
    }
    
}
