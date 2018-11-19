package decorator;

import java.util.LinkedList;

import Bee.Bee;

public class SpawnRoom extends RoomDecorator{
    float spawnRate = 1;
    LinkedList<Bee> spawnList = new LinkedList<Bee>();
    
    public SpawnRoom(Room room) {
        super(room);
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
    
    public void instaSpawn(Bee bee){
        if(bee.getType() == "warrior"){
            this.hive.addWarrior(bee);
        } else {
            this.hive.addWorker(bee);
        }
    }
}
