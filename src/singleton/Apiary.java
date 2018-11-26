package singleton;

import builder.Beehive;
import builder.Beehive.BeehiveBuilder;
import java.util.Hashtable;
import java.util.Set;

import mediator.Colleague;
import mediator.ConcreteMediator;
import mediator.Mediator;

/**
 * Apiary class with a singleton design pattern. This class allows
 * for the creation of an unlimited number of beehives.
 * @author Paul Traxler
 * @date 11/15/18
 *
 */
public class Apiary extends Colleague {
    // Set up singleton instance
    private static Apiary apiary = null;
    public int hiveCount = 0;
    
    // This hashtable will hold all the hives
    private Hashtable<Integer, Beehive> hiveTable = new Hashtable<Integer, Beehive>();
    
    Mediator mediator;
    
    /**
     * Private constructor for use if an instance has not already been
     * created.
     */
    private Apiary(Mediator m) {
        super(m);
        this.mediator = m;
        System.out.println("Apiary Created");
    }
    
    /**
     * Get's the instance of the Apiary. If one isn't available one
     * is created. 
     * @return Apiary instance
     */
    public static Apiary getInstance() {
        // Check if instance exists
        if (apiary == null) {
            // Create one if it doesn't 
            apiary = new Apiary(new ConcreteMediator());
        } else {
            System.out.println("Apiary already exists: Returning instance of Apiary");
        }
        
        return apiary;
    }
    
    /**
     * Spawns a hive with a specified species and queen multiplier.
     * @param species - The species to install in the hive
     * @param queenMultiplier - The strength of the queen/hive
     */
    public Beehive spawnHive(String species, double queenMultiplier) {
        // Hive ID number
        int num = hiveTable.size() + 1;
        
        // Create new Beehive
        Beehive spawn = new BeehiveBuilder(num, species, queenMultiplier, this.mediator).build();

        // Put it in the table
        hiveTable.put(num, spawn);
       
        return spawn;
    }
    
    /**
     * Checks to see if an apiary contains a given hive.
     * @param hive - Hive to check for existance
     * @return True if hive exists, false otherwise
     */
    public boolean containsHive(Beehive hive) {
        if (hiveTable.contains(hive)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Gets the hive associated with a given ID.
     * @param hiveId - the ID number of the hive
     * @return Beehive
     */
    public Beehive getHive(int hiveId) {
        return hiveTable.get(hiveId);
    }
    
    @Override
    public void receive(String message) {
        // TODO Auto-generated method stub
        
    }
}
