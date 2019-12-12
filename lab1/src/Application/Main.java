package Application;


import Vehicle.AbstractCar;
import Vehicle.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Application.Model.cars;

public class Main {


    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Start a new view and send a reference of self
        CarView frame= new CarView("CarSim 1.0", cc);
        Model model = frame.drawPanel.model;
        model.addCars();
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    for (AbstractCar car : cars) {
                        car.move();
                        intersect();
                        cc.speedframe.updateSpeed(cars);
                        int x = (int) Math.round(car.getX());
                        int y = (int) Math.round(car.getY());
                        model.moveit(x, y, cars, car);
                        // repaint() calls the paintComponent method of the panel
                        frame.drawPanel.repaint();
                    }
                }

        });
        // Start the timer
        timer.start();



    }
    static void intersect(){
        for(AbstractCar car: cars){
            if(car.getX()>700){
                car.setDIR(Direction.LEFT);
            }
            if(car.getX()<0){
                car.setDIR(Direction.RIGHT);
            }
            if(car.getY()<0){
                car.setDIR(Direction.DOWN);
            }
            if(car.getY()>500){
                car.setDIR(Direction.UP);
            }
        }
    }


}
