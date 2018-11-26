package decorator;

import java.util.LinkedList;
import mediator.Mediator;
import util.Bee;

/**
 * The spawn room is where new bees are created. When bees are called for they 
 * are spawned based on the spawn rate. 
 * @author ptraxler
 *
 */
public class SpawnRoom extends RoomDecorator {
    private float spawnRate = 1;
    private LinkedList<Bee> spawnList = new LinkedList<Bee>();
    
    /**
     * Basic constructor for the spawn room. 
     * @param room - Base room
     * @param m - Mediator
     */
    public SpawnRoom(Room room, Mediator m) {
        super(room, m);
        System.out.println("- Decorated as type Spawn Room");
    }
    
    @Override 
    public String getType() {
        return "Spawn Room";
    }
    
    /**
     * Sets the spawn rate, but does not allow a negative rate.
     * @param spawnRate - new spawn rate
     */
    public void setSpawnRate(float spawnRate) {
        if (spawnRate >= 0) {
            this.spawnRate = spawnRate;
        } else {
            this.spawnRate = 0;
        }
    }
    
    /**
     * Gets the spawn rate.
     * @return - spawn rate
     */
    public float getSpawnRate() {
        return this.spawnRate;
    }
    
    /**
     * Adds a bee to the list to spawn. 
     * @param bee - Bee to spawn.
     */
    public void spawnBee(Bee bee) {
        spawnList.add(bee);
    }
}
