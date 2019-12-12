package Garage;

import Vehicle.Saab95;

/**
 * represents a garage for the car Vehicle.Saab95
 */
public class SaabGarage extends Garage <Saab95> {

    /**
     * constructs a garage for Vehicle.Saab95 with a maximum number of saab95s it can handle at a time and a position
     * @param maxCars the maximum number of saab95s
     * @param x x-coordinate for the position.
     * @param y y-coordinate for the position.
     */
    public SaabGarage(int maxCars, double x, double y) {
        super(maxCars, x, y);
    }

        /**
         * adds one Vehicle.Saab95 to the garage
         * @param saab95 the specific saab95 car to add
         */
        @Override
        public void addCar(Saab95 saab95) {
        super.addCar(saab95);
    }

}
