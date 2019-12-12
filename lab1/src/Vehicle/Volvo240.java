package Vehicle;

import Vehicle.AbstractCar;

import java.awt.*;

/**
 * Represents a Vehicle.Volvo240
 * that is a car and movable.
 */
public class Volvo240 extends AbstractCar {
    /**
     * A factor who increases the accelaration of the Vehicle.Volvo240
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Vehicle.Volvo240 car with a specified number of doors, a height, a width, a length, a color, a specified amount of engine power, a name of the model and a method that stops the engine.
     * @param x x-coordinate for the position of the car.
     * @param y y-coordinate for the position of the car.
     */
    public Volvo240(double x, double y){
        super(x,y);
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(315);
        setModelName("Vehicle.Volvo240");
        setHeight(140);
        setWidth(171);
        setLength(480);
        stopEngine();
    }

    /**
     * How much the speed will accelerate.
     * @return the factor of acceleration.
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01* trimFactor;
    }

}