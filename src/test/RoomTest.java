package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import builder.Beehive;
import builder.Beehive.BeehiveBuilder;
import decorator.BaseRoom;
import decorator.FoodRoom;
import decorator.RestRoom;
import decorator.SpawnRoom;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import mediator.ConcreteMediator;
import mediator.Mediator;

import org.junit.Before;

import org.junit.Test;

/**
 * This class tests the functions of the Apiary class of the singleton pattern. 
 * We check that we can only create a single instance of an apiary and test hive 
 * creation. 
 * 
 * @author Paul Traxler
 */
public class RoomTest {
    // Set up neccesary objects to create a room. We set up the beehive with a defense multiplier
    // of 1 so it's easier to inflict damage on the rooms. 
    private Mediator mediator = new ConcreteMediator();
    private Beehive hive = new BeehiveBuilder(1,"GLADIATOR", 1, mediator)
                                                   .defenseMultiplier(1).build();
    private ByteArrayOutputStream outTest = new ByteArrayOutputStream();
    
    /**
     * This sets up a stream so that I can check the console output.
     * @throws UnsupportedEncodingException if UTF-8 not supported.
     */
    @Before
    public void setUpStreams() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(outTest, true, "UTF-8"));
    }
    
    /**
     * Tests creation of a spawn room, as well as the getting and setting of the spawn rate.
     * Spawn rate can be any number greater than 10.
     */
    @Test 
    public void spawnRoomTest() {
        SpawnRoom spawnRoom = new SpawnRoom(new BaseRoom(hive), mediator);
        assertTrue(spawnRoom.getType().equals("Spawn Room"));
        
        spawnRoom.setSpawnRate(10);
        assertTrue(spawnRoom.getSpawnRate() == 10);
        
        spawnRoom.setSpawnRate(-1);
        assertFalse(spawnRoom.getSpawnRate() == -1);
        assertTrue(spawnRoom.getSpawnRate() == 0);
    }
    
    /**
     * Tests creation of a food room, which is just a placeholder class at this time.
     * @throws UnsupportedEncodingException - If UTF-8 not supported.
     */
    @Test
    public void foodRoomTest() throws UnsupportedEncodingException {
        FoodRoom foodRoom = new FoodRoom(new BaseRoom(hive), mediator);
        assertTrue(foodRoom.getType().equals("Food room"));  
        
        outTest.reset();
        foodRoom.send("Testing 123");
        assertEquals("Mediator received message from "
                                        + foodRoom
                                        + ": Testing 123\n", outTest.toString("UTF-8"));
    }
    
    /**
     * Tests creation of a rest room, which is just a placeholder class at this time.
     */
    @Test
    public void restRoomTest() {
        RestRoom restRoom = new RestRoom(new BaseRoom(hive), mediator);
        assertTrue(restRoom.getType().equals("Rest room"));        
    }
    
    /**
     * Tests the basic room functions.
     */
    @Test
    public void basicRoomTest() {
        BaseRoom baseRoom = new BaseRoom(hive);
        baseRoom.damage(10);
        
        // Check the health of the room
        assertTrue(baseRoom.getHealth() == 90);
    
        // Attempt to heal the room by 5
        baseRoom.heal(5);
        assertTrue(baseRoom.getHealth() == 95);
        
        // Damage the room allll the way and make sure we cap at 0
        baseRoom.damage(100);
        assertTrue(baseRoom.getHealth() == 0);
        
        // Attempt to heal past 100 and make sure we cap at 100
        baseRoom.heal(105);
        assertTrue(baseRoom.getHealth() == 100);
    }
    
}
