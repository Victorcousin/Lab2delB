package Vehicle;

/**
 * represents a Vehicle.Flatbed
 * that has an angle
 */
public class Flatbed {

    private int angle;

    /**
     * constructs a flatbed with an angle
     * @param angle angle of the tilt of the flatbed
     */
    public Flatbed(int angle){
        this.angle=angle;
    }

    /**
     * gets the angle of the flatbed
     * @return the angle of the tilt
     */
    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle=angle;
    }
}
