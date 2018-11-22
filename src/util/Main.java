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
        // Instantiation of Mediator for Mediator design pattern.
        Mediator mediator = new ConcreteMediator();
        
        // Singleton design demonstration for the Apiary. Only one can be created. 
        System.out.println("SINGLTON DEMONSTATION" );
        System.out.println("Apiary 1 creation result: ");
        Apiary apiary1 = Apiary.getInstance();
        
        System.out.println("Apiary 2 creation result: ");
        Apiary apiary2 = Apiary.getInstance();
        
        apiary1.hiveCount = 2;
        System.out.println("\nApiary 1 hive count set to 2");
        apiary2.hiveCount = 3;
        System.out.println("Apiary 2 hive count set to 3");
        
        System.out.println("Apiary 1 new hive count: " + apiary1.hiveCount);
        
        // Builder Design pattern demonstration. Beehive can't be created directly, must be built
        // from the BeehiveBuilder class. 
        Beehive beehive1 = new BeehiveBuilder("Laborer", 1, mediator).build();
        Beehive beehive2 = new BeehiveBuilder("Warrior", 1.2, mediator).foodRooms(2)
                                                                       .restRooms(3)
                                                                       .defenseMultiplier(2)
                                                                       .build();
        
        // Decorator Design pattern demonstration. Rooms are created by using their specific 
        // decorator class.
        SpawnRoom spawn1 = new SpawnRoom(new BaseRoom(), mediator);
        FoodRoom food1 = new FoodRoom(new BaseRoom(), mediator);
        RestRoom rest1 = new RestRoom(new BaseRoom(), mediator);
    }
}
