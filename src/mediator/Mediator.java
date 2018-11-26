package mediator;

/** 
 * Interface for Mediator class.
 * @author Paul Traxler
 */
public interface Mediator {
    public void send(String message, Colleague coll);    
}
