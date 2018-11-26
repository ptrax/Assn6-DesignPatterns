package decorator;

import mediator.Mediator;

/**
 * The food room holds food for the hive. This is used in the decorator
 * pattern to "decorate" the base room. 
 * @author Paul Traxler
 *
 */
public class FoodRoom extends RoomDecorator {

    public FoodRoom(Room room, Mediator m) {
        super(room, m);
        System.out.println("- Decorated as type Food Room");
    }
    
    @Override 
    public String getType() {
        return "Food room";
    }
}
