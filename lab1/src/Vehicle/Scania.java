package Vehicle;

import java.awt.*;

/**
 * Represents a Vehicle.Scania
 * that is a lorry
 */

public class Scania extends AbstractLorry {

    /**
     * constructs a Vehicle.Scania with a current position, flatbed with 0 as the initial value of tilt, number of doors, a height, a width, a length, color, a specified amount of engine power, a name of the model and a method that stops the engine.
     * @param x x-coordinate for the current position of the lorry
     * @param y y-coordinate for the current position of the lorry
     * @param flatbed a flatbed with the current angle of its tilt
     */
    public Scania (double x, double y, Flatbed flatbed){
        super(x,y,flatbed);
        setNrDoors(2);
        setHeight(350);
        setWidth(260);
        setLength(910);
        setColor(Color.blue);
        setEnginePower(315);
        setModelName("Vehicle.Scania");
        flatbed.setAngle(0);
        stopEngine();
    }

    /**
     * raises the flatbed by increasing the angle about 5 degrees at the time, only if the new angle will be less, or equal to, 70 and the Vehicle.Scania´s speed is zero.
     */
    @Override
    public void raiseFlatbed(){
        if((getFlatbed().getAngle()+5<=70) && (getCurrentSpeed()==0)) {
           getFlatbed().setAngle((getFlatbed().getAngle() + 5));
        }
    }

    /**
     * lowers the flatbed by decreasing the angle about 5 degrees at the time
     */
    @Override
    public void lowerFlatbed(){
        if(getFlatbed().getAngle()-5>=0) {
            getFlatbed().setAngle((getFlatbed().getAngle() -5));
        }
    }

    /**
     * moves the lorry if the flatbed's angle of tilt is zero
     */
    @Override
    public void move() {
        if(getFlatbed().getAngle()==0) {
            super.move();
        }
        else{
            setCurrentSpeed(0);
        }
    }
}
