import Garage.*;
import Vehicle.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class test {

    Saab95 saab95 = new Saab95(2,2);
    Volvo240 volvo240 = new Volvo240(6,2);
    Saab95 turbosaab= new Saab95(3,2);
    Flatbed flatbed=new Flatbed(4);
    Scania scania= new Scania(5,4,flatbed);
    Flatbed flatbedtruck=new Flatbed(4);
    Truck truck= new Truck(5,4,flatbedtruck);

    VolvoGarage volvoGarage = new VolvoGarage(2, 3, 4);
    SaabGarage saabGarage = new SaabGarage(2, 5, 5);
    Garage garage = new Garage(2, 4, 4);

    @Before
    public void alwaysstart(){
        volvo240.startEngine();
        saab95.startEngine();
        turbosaab.startEngine();
    }

    @Test
    public void testDecreaseSpeedsaab() {
        double s = saab95.getCurrentSpeed();
        saab95.decrementSpeed(2);
        assertTrue(s > saab95.getCurrentSpeed());
    }


    @Test
    public void testDecreaseSpeedVolvo() {
        double s = volvo240.getCurrentSpeed();
        volvo240.decrementSpeed(2); // amount begränsas i break till mellan 0 och 1
        assertTrue(s > volvo240.getCurrentSpeed());
    }
        @Test
    public void testIncreaseSpeedsaab(){
        double s= saab95.getCurrentSpeed();
        saab95.incrementSpeed(2.0);
        assertTrue(s<saab95.getCurrentSpeed());
    }

    @Test
    public void testIncreaseSpeedvolvo() {
        double s = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(2.0);
        assertTrue(s < volvo240.getCurrentSpeed());
    }
        @Test
    public void testStopEngine(){
      volvo240.stopEngine();
        assertTrue(volvo240.getCurrentSpeed()==0);
    }


    @Test
    public void testLoadcar(){
        truck.lowerFlatbed();
        truck.loadCar(volvo240);
        System.out.print(truck.loadedcars);
    }

    @Test
    public void testStartEngine(){

        assertTrue(volvo240.getCurrentSpeed()==0.1);
    }

    @Test
    public void testTurboOn(){
        turbosaab.setTurboOn();
        turbosaab.incrementSpeed(2);
        saab95.incrementSpeed(2);
        assertTrue(turbosaab.getCurrentSpeed()>saab95.getCurrentSpeed());
    }

    @Test
    public void testTurboOff(){
        turbosaab.setTurboOff();
        turbosaab.incrementSpeed(2);
        saab95.incrementSpeed(2);
        assertTrue(turbosaab.getCurrentSpeed()==saab95.getCurrentSpeed());
    }

    @Test
    public void TestGas(){
        double s = saab95.getCurrentSpeed();
        saab95.gas(1);
        assertTrue(saab95.getCurrentSpeed()>=s);
    }
    @Test
    public void TestBrake(){
        double s = saab95.getCurrentSpeed();
        saab95.brake(1);
        assertTrue(saab95.getCurrentSpeed()<=s);
    }

    @Test
    public void TestgetAngle(){
        assertTrue(flatbed.getAngle()==0);
    }

    @Test
    public void TestRaise(){
      scania.raiseFlatbed();
        assertTrue(flatbed.getAngle()==5);
    }

    @Test
    public void TestMove(){
        double d= scania.getX();
        scania.gas(0.3);
        scania.setDIR(Direction.RIGHT);
        scania.turnRight();
        scania.turnRight();
        scania.move();
        double x = scania.getX();
        assertTrue(x!=d);
    }

    @Test
    public void TestLower(){
        truck.lowerFlatbed();
        assertTrue(flatbedtruck.getAngle()==0);
    }

    @Test
    public void TestLowermove(){
        double x= truck.getX();
        truck.setDIR(Direction.RIGHT);
        truck.gas(0.4);
        truck.move();
        double d = truck.getX();
        assertTrue(x != d);
    }

    @Test
    public void TestReleaseCar(){
        truck.lowerFlatbed();
        truck.loadCar(volvo240);
        truck.loadCar(saab95);
        truck.loadCar(truck);
        System.out.print(truck.loadedcars);
        int x = truck.loadedcars.size();
        truck.releaseCar();
        System.out.println(truck.loadedcars);
        assertTrue(x>truck.loadedcars.size());
    }

    @Test
    public void TestReleasedX(){
        truck.lowerFlatbed();
        truck.loadCar(volvo240);
        truck.loadCar(saab95);
        double x= saab95.getX();
        truck.releaseCar();
        assertTrue(x==saab95.getX()-2);
    }
    @Test
    public void TestMoveTruck(){
        truck.lowerFlatbed();
        truck.loadCar(volvo240);
        truck.loadCar(saab95);
        double x= saab95.getX();
        truck.raiseFlatbed();
        truck.setDIR(Direction.RIGHT);
        truck.gas(1);
        truck.move();
        double y = saab95.getX();
        assertTrue(x!=y);
    }
    @Test
    public void TestVolvoGarage(){
        volvoGarage.addCar(volvo240);
        volvoGarage.getCar(0);
        System.out.print(volvoGarage.carsInGarage);
    }
    @Test
    public void TestGarage(){
        garage.addCar(volvo240);
        garage.addCar(saab95);
        garage.addCar(saab95);
        assertEquals(2, garage.carsInGarage.size());
    }


}
