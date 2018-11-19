package decorator;

public class RestRoom extends RoomDecorator {

    public RestRoom(Room room) {
        super(room);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String getType() {
        return "Rest room";
    }
    
}
