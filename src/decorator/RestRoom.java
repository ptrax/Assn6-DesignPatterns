package decorator;

import mediator.Mediator;

/** 
 * The rest room holds bees while they rest.
 * @author Paul Traxler
 *
 */
public class RestRoom extends RoomDecorator {
    
    public RestRoom(Room room, Mediator m) {
        super(room, m);
        System.out.println("- Decorated as type Rest Room");
    }

    @Override
    public String getType() {
        return "Rest room";
    }
   
}
