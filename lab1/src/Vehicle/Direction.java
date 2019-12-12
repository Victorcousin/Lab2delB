package Vehicle;

/**
 * An enum of directions the car can face forward to. Each direction(UP,RIGHT,DOWN,LEFT) has a number(0 to 3), that is called numval, attached to them.
 */
public enum Direction {

        UP(0), RIGHT(1), DOWN(2), LEFT(3);
        private int numval;

        /**
         * Takes the value of the direction and copies it to numval.
         * @param i value of the current direction.
         */
         Direction(int i) {
            this.numval=i;
        }

        /**
         * A method to get the current value of numval.
         * @return the current value of numval.
         */
        protected int getNumval(){
            return numval;
        }
    }

