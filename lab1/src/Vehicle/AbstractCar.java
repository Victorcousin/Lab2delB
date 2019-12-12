package Vehicle;

import java.awt.*;
import java.util.zip.DeflaterInputStream;

/**
 * An abstract class of a car, which is movable.
 * The car has a specified number of doors, a specified amount of engine power, a color, a name of the car model.
 * It also has a position that is represented with x and y-coordinates, and a direction of where it is facing forward to.
 */
public abstract class AbstractCar implements Movable {


    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double height;
    private double width;
    private double length;
    private Direction dir= Direction.RIGHT;
    private boolean isLoaded=false;

    /**
     * Constructs a car with a current position.
     * @param x x-coordinate for the current position of the car.
     * @param y y-coordinate for the current position of the car.
     */
    protected AbstractCar(double x, double y) {
        this.x=x;
        this.y=y;
    }

    /**
     * Sets the current y-coordinate.
     * @param y y-coordinate for the current position of the car.
     */
    protected void setY(double y) { //set och get ska vara public
        this.y= y;
    }

    protected void setEnginePower(double enginePower){
        this.enginePower=enginePower;
    }
    /**
     * Sets the current x-coordinate.
     * @param x x-coordinate for the current position of the car.
     */
    protected void setX(double x) {
        this.x = x;
    }

    public void setDIR(Direction dir) {
        this.dir = dir;
    }


    /**
     * Gets the current x-coordinate.
     * @return x-coordinate for the current position of the car.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the current y-coordinate.
     * @return y-coordinate for the current position of the car.
     */
    public double getY() {
        return y;
    }

    public Direction getDIR() {
        return dir;
    }


    /**
     * Method to move the car forward with the current speed.
     * The method uses the different directions to know where the car is facing forward to.
     */
    public void move(){
        switch(dir) {
            case UP:
                setY(getY()-getCurrentSpeed());
                break;
            case RIGHT:
                setX(getX()+getCurrentSpeed());
                break;
            case DOWN:
                setY(getY()+getCurrentSpeed());
                break;
            case LEFT:
                setX(getX()-getCurrentSpeed());
        }
    }

    /**
     * Changes direction so that the car turns left.
     */
    public void turnLeft(){
        dir= Direction.values()[(dir.getNumval()-1)%4];
    }

    /**
     * Changes direction so the car turns right.
     */
    public void turnRight(){
        dir= Direction.values()[(dir.getNumval()+1)%4];
    }
    /**
     * gets the how many doors the car has
     * @return number of the car doors
     */
    private int getNrDoors(){
        return nrDoors;
    }

    /**
     * gets amount of the engine power
     * @return amount of the engine power
     */
    protected double getEnginePower(){
        return enginePower;
    }

    /**
     * gets the current speed of the car
     * @return the current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * gets the current color of the car
     * @return the current color of the car
     */
    private Color getColor(){
        return color;
    }

    /**
     * sets the color of the car to the new chosen color
     * @param clr the new color
     */
    protected void setColor(Color clr) {
        color = clr;
    }

    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    protected void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    protected boolean isLoaded() {
        return isLoaded;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected double getHeight() { return height; }


    protected void setWidth(int width) {
        this.width = width;
    }

    protected double getWidth() { return width; }

    protected void setLength(int length) {
        this.length = length;
    }

    protected double getLength() { return length; }


    protected void setNrDoors(int num) {
        nrDoors =num;
    }

    protected void setCurrentSpeed(int num) {
        currentSpeed =num;
    }

    public String getModelName(){return modelName;}

    /**
     * starts the engine by gaining speed
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * sets speed to 0, so the engine stops
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * takes the current amount of gas in account when decreasing the speed
     * @param amount current amount of gas
     */
    public void gas(double amount){
        if( amount >=0 && amount<=1 ) {
            incrementSpeed(amount);
        }
    }

    /**
     * takes the current amount of brake in account when decreasing the speed
     * @param amount current amount of brake
     */
    public void brake(double amount){
        if( amount >=0 && amount<=1 ) {
            decrementSpeed(amount);
        }
    }

    /**
     * increases the speed depending on the current gas and factor of acceleration.
     * @param amount the current amount of gas
     */
    public void incrementSpeed(double amount) {
        if ((getCurrentSpeed() + speedFactor() * amount) <= enginePower) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }
        else {
            currentSpeed=enginePower;
        }
    }

    /**
     * decreases the speed depending on the current brake and factor of acceleration.
     * @param amount the current amount of brake
     */
    public void decrementSpeed(double amount) {
        if (getCurrentSpeed() - speedFactor() * amount >= 0) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
        else {
            currentSpeed=0;
        }
    }


    /**
     * How much the speed will accelerate, which depends on which car-model it is (abstract).
     * @return the factor of acceleration.
     */
    protected abstract double speedFactor();
}