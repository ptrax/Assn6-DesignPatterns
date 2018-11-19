package decorator;

public class FoodRoom extends RoomDecorator{

    public FoodRoom(Room room) {
        super(room);
    }
    
    @Override 
    public String getType(){
        return "Food Room";
    }

    public void consumeFood(int amount){
        currentFill -= amount;
    }
}
