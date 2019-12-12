package Application;

import Vehicle.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {

    // To keep track of a singel cars position
    // A list of cars, modify if needed
    static ArrayList<AbstractCar> cars = new ArrayList<>();

    int[] arrayX=new int[10];
     int[] arrayY=new int[10];
   private int count=0;
    private int nCars;
    String[] carModel = new String[10];

    public void setCount(int count) {
        this.count = count;
    }
    public void setnCars(int num) {
         this.nCars= num;
    }

    public int getCount() {
        return count;
    }
    public int getnCars() {
        return nCars;
    }


    void moveit(int x, int y, ArrayList<AbstractCar> cars, AbstractCar car) {
        arrayX[getCount()] = x;
        arrayY[getCount()] = y;

        checkInstance( car);
        checksize();

       setnCars(cars.size());
    }

    public void addCars(){
        cars.add(CarFactory.createVolvo(0,0));
        cars.add(CarFactory.createSaab(0, 160));
        cars.add(CarFactory.createScania(0, 320));
    }
    private void checksize(){
        if (!cars.isEmpty()) {
            count++;
        }
        if (count == cars.size()) {
            setCount(0);
        }
    }
    private void checkInstance(AbstractCar car){
        if (car instanceof Volvo240){ carModel[getCount()] = "Volvo240"; }
        if (car instanceof Saab95) { carModel[getCount()] = "Saab95";}
        if (car instanceof Scania) { carModel[getCount()] = "Scania";}

    }



}
