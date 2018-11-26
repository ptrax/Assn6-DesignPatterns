package test;

import static org.junit.Assert.assertTrue;

import builder.Beehive;
import org.junit.Test;
import singleton.Apiary;

/**
 * This class tests the functions of the Apiary class of the singleton pattern. 
 * We check that we can only create a single instance of an apiary and test hive 
 * creation. 
 * 
 * @author Paul Traxler
 *
 */
public class ApiaryTest {
    // Global variable for use in both tests.
    Apiary apiary1 = Apiary.getInstance();
    
    /**
     * This test checks to make sure only a single instance is created of the apiary.
     */
    @Test
    public void singleInstanceTest() {
        Apiary apiary2 = Apiary.getInstance();
        assertTrue(apiary1.equals(apiary2));
    }
    
    /**
     * This test attempts to spawn a hive in the apiary then checks that it was actually
     * created and checks the species and queen multiplier of the created hive.
     */
    @Test
    public void spawnHiveTest() {
        // Create hive and confirm creation
        Beehive hive = apiary1.spawnHive("GLADIATOR", 1.2);
        assertTrue(apiary1.containsHive(hive));
        
        // Check queen multiplier and species
        assertTrue(Math.abs(apiary1.getHive(1).getQueenMultiplier() - 1.2) < .001);
        assertTrue(apiary1.getHive(1).getSpecies() == "GLADIATOR");
        
    }

}
