package Vehicle;

import Vehicle.AbstractCar;

import java.awt.*;
/**
 * Represents a Vehicle.Saab95
 * that is a car.
 */
public class Saab95 extends AbstractCar {
    /**
     * true/false if turbo is on/off
     */
    private boolean turboOn;

    /**
     * constructs a Vehicle.Saab95-car with a specified number of doors, a height, a width, a length, a color, a specified amount of engine power, if the car has "turbo-mode" selected from start, a name of the model and that can stop it's engine whenever wanted.
     * @param x x-coordinate for the position of the car.
     * @param y y-coordinate for the position of the car.
     */
    public Saab95(double x, double y){
        super(x, y);
        setNrDoors(2);
        setHeight(160);
        setWidth(150);
        setLength(500);
        setColor(Color.red);
        setEnginePower(315);
	    turboOn = false;
	    setModelName("Vehicle.Saab95");
        stopEngine();
    }

    /**
     * activates turbo
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * deactivates turbo
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * how much the speed will accelerate.
     * @return factor of acceleration
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower()*0.01 * turbo;
    }


}
