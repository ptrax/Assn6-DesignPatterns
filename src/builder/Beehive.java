package builder;

import decorator.BaseRoom;
import decorator.FoodRoom;
import decorator.RestRoom;
import decorator.Room;
import decorator.SpawnRoom;

import java.util.Hashtable;

import mediator.Colleague;
import mediator.Mediator;
import util.Bee;
import util.Species;

/**
 * A Beehive object is created with a Builder design pattern, with required species and queen
 * multiplier values. The user can also determine the number of worker and warrior bees,
 * the number of different types of rooms, and the hive defense multiplier. 
 * 
 * <p>The Queen Defense Multiplier determines the strength of the bee colony. All traits are 
 * affected by this multiplier. The hive itself takes the queen multiplier into consideration
 * when initializing default values. 
 * 
 * <p>The Hive Defense Multiplier determines how hard it is for bees to damage the hive. Bees can
 * attack other bees, or they can attack the hive. A higher hive defense multiplier means the 
 * attacking bees will do less damage over time. 
 * 
 *  <p>Spawn rooms are used specifically for spawning new bees. 
 *  
 *  <p>Rest rooms are used specifically for resting bees
 *  
 *  <p>Food rooms are used specifically for storing food that has been gathered. 
 * @author ptraxler
 *
 */
public class Beehive {
    // REQUIRED by builder
    private String currentSpecies; // Any species can be here, but only 1 at a time
    private double queenMultiplier;   // The Queen strength effects the workers and warriors
    
    // OPTIONAL by builder.. if not implemented a default will be chosen based on species.
    private int workerBees;        // All species have workers...
    private int warriorBees;       // ... and warriors. 
    private double hiveDefenseMultiplier; // This dictates how easy it is for other bees to damage
    private int initSpawnRooms = 1;    // Number of spawn rooms to start with 
    private int initRestRooms = 1;     // Number of rest rooms to start with
    private int initFoodRooms = 1;     // Number of food rooms to start with
    
    // Here we set up 3 different kinds of rooms. Spawn rooms are for berthing new bees,
    // Rest Rooms are for resting, food rooms are for storing food. 
    private Hashtable<Integer, Room> spawnRooms = new Hashtable<Integer, Room>();
    private Hashtable<Integer, Room> restRooms = new Hashtable<Integer, Room>();
    private Hashtable<Integer, Room> foodRooms = new Hashtable<Integer, Room>();
    
    private Hashtable<Integer, Bee> workerBeeList = new Hashtable<Integer, Bee>();
    private Hashtable<Integer, Bee> warriorBeeList = new Hashtable<Integer, Bee>();
    
    private Mediator mediator;

    
    /**
     * First constructor, set the species and sets up the hive based on that species.
     * @param builder - The builder object that built the hive
     */
    public Beehive(BeehiveBuilder builder) {
        // Set up the required species and queen multiplier
        this.currentSpecies = builder.currentSpecies;
        this.queenMultiplier = builder.queenMultiplier;
        this.mediator = builder.mediator;
        
        // Set up the worker bee number based on builder or species default
        if (builder.workerBees != -1) {
            this.workerBees = builder.workerBees;
        } else {
            this.workerBees = Species.valueOf(currentSpecies).getDefaultWorkers();
        }
        
        // Set up the warrior bee number based on builder or species default
        if (builder.warriorBees != -1) {
            this.warriorBees = builder.warriorBees;
        } else {
            this.warriorBees = Species.valueOf(currentSpecies).getDefaultWarriors();
        }
        
        // Set up the hive defense multiplier based on builder or species default
        if (builder.hiveDefenseMultiplier != -1) {
            this.hiveDefenseMultiplier = builder.hiveDefenseMultiplier;
        } else {
            this.hiveDefenseMultiplier = Species.valueOf(currentSpecies).getDefaultHiveDefense();
        }
        
        // Set up all the spawn rooms based on builder, but the rooms don't get affected
        // by species type
        if (builder.initSpawnRooms != -1) {
            this.initSpawnRooms = builder.initSpawnRooms;
        }
        
        for (int i = 0; i < this.initSpawnRooms; i++) {
            SpawnRoom spawnRoom = new SpawnRoom(new BaseRoom(), this.mediator);
            spawnRooms.put(i, spawnRoom);
        }
        
        if (builder.initRestRooms != -1) {
            this.initRestRooms = builder.initRestRooms;
        }
        
        for (int i = 0; i < this.initRestRooms; i++) {
            RestRoom restRoom = new RestRoom(new BaseRoom(), this.mediator);
            restRooms.put(i, restRoom);
        }
        
        if (builder.initFoodRooms != -1) {
            this.initFoodRooms = builder.initFoodRooms;
        }
        
        for (int i = 0; i < this.initFoodRooms; i++) {
            FoodRoom foodRoom = new FoodRoom(new BaseRoom(), this.mediator);
            foodRooms.put(i, foodRoom);
        }
        
    }
    
    public void addWorker(Bee bee) {
        this.workerBeeList.put(workerBeeList.size() + 1, bee);
    }
    
    public void addWarrior(Bee bee) {
        this.warriorBeeList.put(warriorBeeList.size() + 1, bee);
    }
    
    /**
     * Builder for the Beehive, takes required values of Species and Queen Multiplier, and accepts
     * other input such as worker/warrior bee numbers, hive defense multiplier, and room numbers. 
     * @author Paul Traxler
     *
     */
    public static class BeehiveBuilder extends Colleague {
        // REQUIRED by builder
        private String currentSpecies; // Any species can be here, but only 1 at a time
        private double queenMultiplier;   // The Queen strength effects the workers and warriors
        
        // OPTIONAL by builder.. if not implemented a default will be chosen based on species.
        // We initialize these all to -1 so we can tell if they've been set or not. 
        private int workerBees = -1;        // All species have workers...
        private int warriorBees = -1;       // ... and warriors. 
        private double hiveDefenseMultiplier = -1; // Dictates how easily the hive incurs damage
        private int initSpawnRooms = -1;    // Number of spawn rooms to start with 
        private int initRestRooms = -1;     // Number of rest rooms to start with
        private int initFoodRooms = -1;     // Number of food rooms to start with
        
        private Mediator mediator;
        
        /**
         * Required constructor to create a new Beehive with a species and a queen strength. 
         * If no other attributes are given, these two things will combine to determine all 
         * other options. 
         * @param species - The species to start in the hive
         * @param queenMult - The strength of the queen (and thereby the hive)
         */
        public BeehiveBuilder(String species, double queenMult, Mediator m) {
            super(m);
            this.currentSpecies = species;
            this.queenMultiplier = queenMult;
            this.mediator = m;
        }
        
        /**
         * Optional set method for the number of worker bees. If this isn't set at creation, 
         * a number of bees will be selected based on species and queen strength. 
         * @param n - Number of worker bees to spawn with the hive
         * @return BeehiveBuilder object
         */
        public BeehiveBuilder workerBees(int n) {
            this.workerBees = n;
            
            return this;
        }
        
        /**
         * Optional set method for the number of worker bees. If this isn't set at creation, 
         * a number of bees will be selected based on species and queen strength. 
         * @param n - Number of warrior bees to spawn with the hive
         * @return BeehiveBuilder object
         */
        public BeehiveBuilder warriorBees(int n) {
            this.warriorBees = n;
            
            return this;
        }

        /**
         * Optional set method for the hive defense multiplier. If this isn't set at creation, 
         * a multiplier will be determined based on species and queen strength.  
         * @param mult - Defense Multiplier to give a hive
         * @return BeehiveBuilder object
         */
        public BeehiveBuilder defenseMultiplier(double mult) {
            this.hiveDefenseMultiplier = mult;
            
            return this;
        }
        
        /**
         * Optional set method for the initial number of spawn rooms. If this isn't set at  
         * creation, the default number of spawn rooms is 1. 
         * @param rooms - Number of spawn rooms to start the hive with
         * @return BeehiveBuilder object
         */
        public BeehiveBuilder spawnRooms(int rooms) {
            this.initSpawnRooms = rooms;
            
            return this;
        }
        
        /**
         * Optional set method for the initial number of rest rooms. If this isn't set at  
         * creation, the default number of restRooms is 1.
         * @param rooms - Number of rest rooms to start the hive with
         * @return BeehiveBuilder object
         */
        public BeehiveBuilder restRooms(int rooms) {
            this.initRestRooms = rooms;
            
            return this;
        }
        
        /**
         * Optional set method for the initial number of food rooms. If this isn't set at  
         * creation, the default number of foodRooms is 1. 
         * @param rooms - Number of food rooms to start the hive with
         * @return BeehiveBuilder object
         */
        public BeehiveBuilder foodRooms(int rooms) {
            this.initRestRooms = rooms;
            
            return this;
        }
        
        /**
         * Creates the Beehive.
         * @return Beehive
         */
        public Beehive build() {
            return new Beehive(this);
        }

        @Override
        public void receive(String message) {
            // TODO Auto-generated method stub
            
        }
        
    }
    
}
