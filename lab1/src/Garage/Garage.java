package Garage;

import Vehicle.AbstractCar;

import java.util.ArrayList;
import java.util.List;

/**
 * represents a garage
 * that can handle cars
 * @param <car> which type of car the garage can handle, in this case; all types
 */
public class Garage <car extends AbstractCar>{
    private int maxCars;
    private double x;
    private double y;

    public List<car> carsInGarage= new ArrayList<>(maxCars);

    /**
     * constructs a garage with a position and a maximum number of cars it can handle at a time
     * @param maxCars the maximum number of cars
     * @param x x-coordinate for the position.
     * @param y y-coordinate for the position.
     */
    public Garage(int maxCars, double x, double y){
        this.maxCars= maxCars;
        this.x=x;
        this.y=y;
    }

    /**
     * picks out one selected car from the garage
     * @param carNumber the number that says in which section the car is in the garage (position in list)
     * @return the chosen car to take out
     */
    public car getCar(int carNumber){
        car c=carsInGarage.get(carNumber);
        removeCar(c);
        return c;
    }

    protected void removeCar(car c){
        carsInGarage.remove(c);
    }

    /**
     * adds one specific car to the garage, if there is a free place
     * @param car the car to add
     */
    public void addCar(car car){
        if(carsInGarage.size()<maxCars) {
            carsInGarage.add(car);
        }
    }
}
