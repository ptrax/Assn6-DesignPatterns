package decorator;

abstract class RoomDecorator extends Room{
    private Room baseRoom;
    
    public RoomDecorator(Room room) {
        this.baseRoom = room;
    }
}
