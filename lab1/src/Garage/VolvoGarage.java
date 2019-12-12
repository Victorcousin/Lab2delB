package Garage;

import Vehicle.Volvo240;

/**
 * represents a garage for the car Vehicle.Volvo240
 */
public class VolvoGarage extends Garage <Volvo240>{

    /**
     * constructs a garage for Vehicle.Volvo240 with a maximum number of volvo240s it can handle at a time and a position
     * @param maxCars the maximum number of volvo240s
     * @param x x-coordinate for the position.
     * @param y y-coordinate for the position.
     */
    public VolvoGarage(int maxCars, double x, double y) {
        super(maxCars, x, y);
    }

    /**
     * adds one Vehicle.Volvo240 to the garage
     * @param car the specific volvo240 car to add
     */
    @Override
    public void addCar(Volvo240 car){
        super.addCar(car);
    }

}

