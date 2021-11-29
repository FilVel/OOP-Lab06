package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{

    private static final long serialVersionUID = 5322262957171100503L;
    private final double batteryLevel;
    private final double batteyRequired;

    /**
     * 
     * @param cuurentLevel
     *            current battery level
     * @param required
     *            level required to perform move
     */
    public NotEnoughBatteryException(final double currentLevel, final double required) {
        super();
        this.batteryLevel = currentLevel;
        this.batteyRequired = required;
    }

    /**
     * 
     * @return string representation of this exception
     */
    @Override
    final public String toString() {
        return "There is not enough energy inside the battery. Current battery is " + batteryLevel
            + " while to move " + batteyRequired + " is required!";
    }

    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String getMessage() {
        return this.toString();
    }
}
