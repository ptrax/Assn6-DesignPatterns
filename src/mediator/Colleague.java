package mediator;

/**
 * Abstract class to handle sending and receiving messages in the different classes.
 * @author Paul Traxler
 */
public abstract class Colleague {
    private Mediator mediator;
    
    /**
     * Basic colleague constructor.
     * @param m - Mediator
     */
    public Colleague(Mediator m) {
        this.mediator = m;
    }
    
    /**
     * Send a message through the mediator.
     * @param message - message to send.
     */
    public void send(String message) {
        mediator.send(message,  this);
    }
    
    /**
     * Gets the mediator. 
     * @return mediator
     */
    public Mediator getMediator() {
        return this.mediator;
    }
    
    /**
     * Reveives a message. 
     * @param message - message to receive. 
     */
    public abstract void receive(String message);
}
