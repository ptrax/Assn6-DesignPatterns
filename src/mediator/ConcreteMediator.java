package mediator;

/**
 * Concrete mediator implementation giving the mediator some meaning, handles sending messages.
 * @author Paul Traxler
 *
 */
public class ConcreteMediator implements Mediator {

    /**
     * Gets a message and prints it to the console.
     */
    public void send(String message, Colleague coll) {
        System.out.println("Mediator received message from " + coll + ": " + message);
    }

}
