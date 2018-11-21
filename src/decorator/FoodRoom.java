package decorator;

import mediator.Mediator;

public class FoodRoom extends RoomDecorator {

    public FoodRoom(Room room, Mediator m) {
        super(room, m);
    }
    
    @Override 
    public String getType() {
        return "Food Room";
    }

    public void consumeFood(int amount) {
        this.currentFill -= amount;
    }
}
