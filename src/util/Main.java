package util;

import builder.Beehive;
import builder.Beehive.BeehiveBuilder;
import decorator.BaseRoom;
import decorator.FoodRoom;
import decorator.RestRoom;
import decorator.SpawnRoom;
import mediator.ConcreteMediator;
import mediator.Mediator;
import singleton.Apiary;

public class Main {
    /**
     * Main method for running application. Just gives an demo showing the design patterns working
     * @param args - args
     */
    public static void main(String[] args) {
        
        // Singleton design demonstration for the Apiary. Only one can be created. 
        System.out.println("SINGLTON DEMONSTATION");
        System.out.println("Apiary 1 creation result: ");
        Apiary apiary1 = Apiary.getInstance();
        
        System.out.println("Apiary 2 creation result: ");
        Apiary apiary2 = Apiary.getInstance();
        
        apiary1.hiveCount = 2;
        System.out.println("\nApiary 1 hive count set to 2");
        apiary2.hiveCount = 3;
        System.out.println("Apiary 2 hive count set to 3");
        
        System.out.println("Apiary 1 new hive count: " + apiary1.hiveCount);
        
        // Instantiation of Mediator for Mediator design pattern.
        Mediator mediator = new ConcreteMediator();
        
        // Builder Design pattern demonstration. Beehive can't be created directly, must be built
        // from the BeehiveBuilder class. The beehives also create rooms. 
        System.out.println("\nBUILDER deomonstration (Beehives create rooms when initialized)\n");
        System.out.println("First Beehive: ");
        Beehive beehive1 = new BeehiveBuilder(1, "LABORER", 1, mediator).build();
        System.out.println("\nSecond Beehive: ");
        Beehive beehive2 = new BeehiveBuilder(2, "GLADIATOR", 1.2, mediator).restRooms(3)
                                                                       .defenseMultiplier(2)
                                                                       .build();
        
        // Decorator Design pattern demonstration. Rooms are created by using their specific 
        // decorator class.
        System.out.println("\nDECORATOR demonstration");
        final SpawnRoom spawn1 = new SpawnRoom(new BaseRoom(beehive1), mediator);
        final FoodRoom food1 = new FoodRoom(new BaseRoom(beehive2), mediator);
        final RestRoom rest1 = new RestRoom(new BaseRoom(beehive1), mediator);
        
        // Mediator Demonstration
        System.out.println("\nMEDIATOR demonstration: ");
        beehive1.send("Beehive1 message");
        beehive2.send("Beehive2 message");
        apiary1.send("Apiary message");
        spawn1.send("Spawn Room message");
        food1.send("Food room message");
        rest1.send("Rest room message");
    }
}
