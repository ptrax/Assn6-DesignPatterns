package util;

import singleton.Apiary;

public class Main {
    /**
     * Main method for running application. Just gives an demo showing the design patterns working
     * @param args - args
     */
    public static void main(String[] args) {
        // Basic Apiary demonstration. Singleton design, only one can be created. 
        System.out.println("Apiary 1 creation result: ");
        Apiary apiary1 = Apiary.getInstance();
        
        System.out.println("Apiary 2 creation result: ");
        Apiary apiary2 = Apiary.getInstance();
        
        apiary1.hiveCount = 2;
        System.out.println("\nApiary 1 hive count set to 2");
        apiary2.hiveCount = 3;
        System.out.println("Apiary 2 hive count set to 3");
        
        System.out.println("Apiary 1 new hive count: " + apiary1.hiveCount);
        
    }
}
