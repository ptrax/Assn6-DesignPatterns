package decorator;

import builder.Beehive;
import mediator.Mediator;

/**
 * Interface for the Room class, the basis of our decorator pattern.
 * @author Paul Traxler
 *
 */
public interface Room extends Mediator {

    public void damage(double amount);

    public void heal(double amount);

    public double getHealth();

    public String getType();

    public int getMaxCapacity();

    public int getCurrentFill();

    public int fillRoom(int num);

}
