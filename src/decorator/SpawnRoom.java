package decorator;

import java.util.LinkedList;
import mediator.Mediator;
import util.Bee;

public class SpawnRoom extends RoomDecorator {
    float spawnRate = 1;
    LinkedList<Bee> spawnList = new LinkedList<Bee>();
    
    public SpawnRoom(Room room, Mediator m) {
        super(room, m);
    }
    
    @Override 
    public String getType() {
        return "Spawn Room";
    }

    public void setSpawnRate(float spawnRate) {
        this.spawnRate = spawnRate;
    }
    
    public float getSpawnRate() {
        return this.spawnRate;
    }
    
    public void spawnBee(Bee bee) {
        spawnList.add(bee);
    }
    
    public void instaSpawn(Bee bee) {
        Bee tempBee = new Bee();
        if (bee.getType() == "warrior") {
            this.hive.addWarrior(tempBee);
        } else {
            this.hive.addWorker(bee);
        }
    }
}
