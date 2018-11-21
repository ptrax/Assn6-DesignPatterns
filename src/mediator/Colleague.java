package mediator;

public abstract class Colleague {
    private Mediator mediator;
    
    public Colleague(Mediator m) {
        this.mediator = m;
    }
    
    public void send(String message) {
        mediator.send(message,  this);
    }
    
    public Mediator getMediator() {
        return this.mediator;
    }
    
    public abstract void receive(String message);
}
