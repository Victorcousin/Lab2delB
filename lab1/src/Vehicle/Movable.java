package Vehicle;

/**
 * Specification for objects that is movable
 */

public interface Movable {
    /**
     * Method to move the vehicle.
     */
    void move();

    /**
     * Method to turn the vehicle left.
     */
    void turnLeft();

    /**
     * Method to turn the vehicle right.
     */
    void turnRight();
}