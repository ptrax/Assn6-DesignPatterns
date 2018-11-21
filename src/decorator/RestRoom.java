package decorator;

import mediator.Mediator;

public class RestRoom extends RoomDecorator {
    
    public RestRoom(Room room, Mediator m) {
        super(room, m);
    }

    @Override
    public String getType() {
        return "Rest room";
    }
   
}
