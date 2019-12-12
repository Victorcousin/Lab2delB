package Vehicle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a truck
 * that is a lorry
 */
public class Truck extends AbstractLorry implements Movable{

    /**
     * the cars that is on the truck
     */
    public List<AbstractCar> loadedcars = new ArrayList<>(10);

    /**
     * constructs a truck with a specified number of doors, a height, a width, a length, a color, a specified amount of engine power, a name of the model, a flatbed that is at it´s upper position, and that can stop it's engine whenever wanted.
     * @param x x-coordinate for the position of the lorry.
     * @param y y-coordinate for the position of the lorry.
     * @param flatbed the flatbed of the lorry
     */
    public Truck (double x, double y, Flatbed flatbed){
        super(x,y,flatbed);
        setNrDoors(2);
        setHeight(500);
        setWidth(260);
        setLength(3000);
        setColor(Color.blue);
        setEnginePower(315);
        setModelName("Vehicle.Truck");
        flatbed.setAngle(1);
        stopEngine();
    }

    /**
     * places the car on the truck if the flatbed is at it´s lower position, the car is fairly nearby the truck, and the car´s size is suitable for the truck.
     * It also sets the car´s coordinates to the same as the trucks if the car loads onto the truck.
      * @param car the car that wants to be loaded to the truck
     */
    public void loadCar(AbstractCar car) {
      if(  car != this && !car.isLoaded()) {
          if (getFlatbed().getAngle() == 0 && (isNearby(car))  && (checkSize(car))) {
              loadedcars.add(car);
              car.setX(getX());
              car.setY(getY());
              car.setLoaded(true);
          }
      }
    }

    /**
     * checks if the car´s coordinates is nearby the truck´s within the value of 5
     * @param car the car that shall be checked if it´s nearby the truck
     * @return if the car is nearby or not
     */
    public boolean isNearby(AbstractCar car){
        return (car.getX() <= getX() + 5 && car.getX() >= getX() - 5) && (car.getY() <= getY() + 5 && car.getY() >= getY() - 5);
    }

    /**
     * checks if car´s size is suitable for the truck by checking so the height, width and length of the car isn´t bigger than the truck can manage
     * @param car the car which size shall be checked
     * @return if the size of the car is suitable for the truck
     */
   public boolean checkSize(AbstractCar car){
       return car.getHeight() <= 200 && car.getWidth() <= 180 && car.getLength() <= 520;
   }

    /**
     * releases the most recently loaded car if the flatbed is at its lower position
     */
    public void releaseCar(){
        if(getFlatbed().getAngle()==0) {
            if (loadedcars.size() > 0) {
                AbstractCar car = loadedcars.get(loadedcars.size()-1);
                loadedcars.remove(loadedcars.size()-1);
                car.setX(getX() + 2);
                car.setLoaded(false);
            }
        }
    }

    /**
     * sets the flatbed of the truck at it´s upper position
     */
    @Override
    public void raiseFlatbed() {
        getFlatbed().setAngle(1);
    }

    /**
     * sets the flatbed of the truck at it´s lower position if the truck has no speed
     */
    @Override
    public void lowerFlatbed() {
        if(getCurrentSpeed()==0) {
            getFlatbed().setAngle(0);
        }
    }

    /**
     * moves the truck if the flatbed of the truck is at it´s upper position.
     * when the truck moves, also the cars that is loaded on the truck´s x- and y-coordinates sets to be the same as the truck´s coordinates
     */
    @Override
    public void move() {
        if(getFlatbed().getAngle()==1) {
            super.move();
            for(AbstractCar c:loadedcars){
                c.setY(getY());
                c.setX(getX());
            }
        }
    }
}
