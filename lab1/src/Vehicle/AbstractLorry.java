package Vehicle;

import Vehicle.AbstractCar;

/**
 * An abstract class of a lorry, that is an expanded car.
 * a lorry has a flatbed
 */
    public abstract class AbstractLorry extends AbstractCar {

       private Flatbed flatbed;



    /**
     * constructs a lorry with a current position and a flatbed.
     * @param x x-coordinate for the current position of the lorry
     * @param y y-coordinate for the current position of the lorry
     * @param flatbed a flatbed with the current angle of its tilt
     */
        public AbstractLorry(double x, double y, Flatbed flatbed){
            super(x,y);
            this.flatbed=flatbed;
        }
    /**
     * How much the speed will accelerate.
     * @return the factor of acceleration.
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }


    public void setFlatbed(Flatbed flatbed) {
        this.flatbed = flatbed;
    }

    public Flatbed getFlatbed() {
        return flatbed;
    }
    /**
     * raises the flatbed. depending on which lorry-model it is (abstract)
     */
    protected abstract void raiseFlatbed();
    /**
     * lowers the flatbed. depending on which lorry-model it is (abstract)
     */
    protected abstract void lowerFlatbed();
    }

