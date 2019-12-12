package Application;

import Vehicle.*;

public  class CarFactory {

    protected static AbstractCar createSaab(double x, double y){
        return new Saab95(x, y);
    }
    protected static AbstractCar createVolvo(double x, double y){
        return new Volvo240(x, y);
    }
    protected static AbstractCar createScania(double x, double y){
        return new Scania(x, y,new Flatbed(0));
    }
}
