package util;

/**
 * This Enum holds the default values for the four species of bees.
 * @author Paul Traxler
 *
 */
public enum Species {
    LABORER, GLADIATOR, HEALER, ENERGIZER;
    
    private int defaultWorkers = 25;
    private int defaultWarriors = 25; 
    private double defaultHiveDefense = 1;
    
    private Species() {
        if (this.toString().equals("LABORER")) {
            defaultWorkers = 30;
            defaultWarriors = 20; 
            defaultHiveDefense = 1.2;
        }
        
        if (this.toString().equals("GLADIATOR")) {
            defaultWorkers = 25;
            defaultWarriors = 25; 
            defaultHiveDefense = .9;
        }
        
        
        if (this.toString().equals("MEDIC")) {
            defaultWorkers = 28;
            defaultWarriors = 22; 
            defaultHiveDefense = 1;
        }
        
        if (this.toString().equals("ENERGIZER")) {
            defaultWorkers = 20;
            defaultWarriors = 20; 
            defaultHiveDefense = .8;
        }
    }
    
    /**
     * Getter for the default worker number.
     * @return default workers
     */
    public int getDefaultWorkers() {
        return this.defaultWorkers;
    }
    
    /**
     * Getter for the default warrior number.
     * @return default warriors
     */
    public int getDefaultWarriors() {
        return this.defaultWarriors;
    }
    
    /**
     * Getter for the default Hive Defense multiplier.
     * @return default hive defense 
     */
    public double getDefaultHiveDefense() {
        return this.defaultHiveDefense;
    }
    
}