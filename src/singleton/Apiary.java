package singleton;

import builder.Beehive;
import builder.Beehive.BeehiveBuilder;
import java.util.Hashtable;
import mediator.Mediator;

/**
 * Apiary class with a singleton design pattern. This class allows
 * for the creation of an unlimited number of beehives.
 * @author Paul Traxler
 * @date 11/15/18
 *
 */
public class Apiary {
    // Set up singleton instance
    private static Apiary apiary = null;
    public int hiveCount = 0;
    
    // This hashtable will hold all the hives
    Hashtable<Integer, Beehive> hiveTable = new Hashtable<Integer, Beehive>();
    
    Mediator mediator;
    
    /**
     * Private constructor for use if an instance has not already been
     * created.
     */
    private Apiary() {
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
            apiary = new Apiary();
        } else {
            System.out.println("Apiary already exists: Returning instance of Apiary");
        }
        
        return apiary;
    }
    
    /**
     * Spawns a hive with a specified species and queen multiplier. Returns a
     * BeehiveBuilder object that you can use to fill out optional fields.
     * To create a Beehive object, you must call
     * <code>spawnHive(species, multiplier).build()</code> 
     * @param species - The species to install in the hive
     * @param queenMultiplier - The strength of the queen/hive
     */
    public BeehiveBuilder spawnHive(String species, double queenMultiplier) {
        return new BeehiveBuilder(species, queenMultiplier, this.mediator);
    }
    
    /**
     * Gets the Hashtable containing the Beehives. The key is based on the hive's
     * spawn order. 
     * @return Hashtable of Beehives
     */
    public Hashtable<Integer, Beehive> getHives() {
        return hiveTable;
    }
}
