package decorator;

import builder.Beehive;
import mediator.Colleague;
import mediator.Mediator;

/**
 * Decorator class for the Rooms, extends Colleague class so we can get communication
 * with the Mediator. Passes methods through to underlying room.
 * @author Paul Traxler
 */
public class RoomDecorator extends Colleague implements Room {
    protected Room room;
    
    Mediator mediator = null;
    
    
    protected RoomDecorator(Room room, Mediator m) {
        super(m);
        this.room = room;
        this.mediator = m;
    }
    
    public String getType() {
        return this.room.getType();
    }

    public void send(String message, Colleague coll) {
        mediator.send(message, coll);
    }

    public void damage(double amount) {
        this.room.damage(amount);
        
    }

    public void heal(double amount) {
        this.room.heal(amount);        
    }

    public double getHealth() {
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

    @Override
    public void receive(String message) {
        // TODO Auto-generated method stub
        
    }
}
