package Application;

import Vehicle.*;
import Application.Model;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static Application.Model.cars;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    Random rand = new Random();

    // The frame that represents this instance View of the MVC pattern

    SpeedView speedframe = new SpeedView("title", cars);


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.gas(gas);
        }
    }
    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractCar car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOn(){
        for (AbstractCar car: cars){
            if (car instanceof Saab95 ){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff(){
        for (AbstractCar car: cars){
            if (car instanceof Saab95 ){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void liftFlatbed(){
        for (AbstractCar car: cars){
            if (car instanceof Scania ){
                ((Scania) car).raiseFlatbed();
            }
        }
    }
    void lowerFlatbed(){
        for (AbstractCar car: cars){
            if (car instanceof Scania ){
                ((Scania) car).lowerFlatbed();
            }
        }
    }
    void startAll(){
        for (AbstractCar car: cars){
            car.startEngine();
        }
    }
    void stopAll(){
        for (AbstractCar car: cars){
            car.stopEngine();
        }
    }
    void addCar(){
        if(cars.size()<10) {
            int randomCar = rand.nextInt(3);
            int randomX = rand.nextInt(600);
            int randomY = rand.nextInt(400);
            if (randomCar == 0) {
                cars.add(CarFactory.createVolvo(randomX, randomY));
            }
            if (randomCar == 1) {
                cars.add(CarFactory.createSaab(randomX, randomY));
            }
            if (randomCar == 2) {
               cars.add(CarFactory.createScania(randomX, randomY));
            }
        }
    }

    void removeCar() {
        if (!cars.isEmpty()) {
            int randomCar = rand.nextInt(cars.size());
            cars.remove(randomCar);
        }
        if(cars.isEmpty()){
            speedframe.updateSpeed(cars);
        }

    }



}
