package quantitymeasurement.entity;

/**
 * Represents QuantityDTO.
 */
public class QuantityDTO {
    /**
     * Represents IMeasurableUnit.
     */
    public interface IMeasurableUnit {}
    /**
     * Represents LengthUnit.
     */
    public enum LengthUnit implements IMeasurableUnit { FEET, INCHES, YARD, CM }
    /**
     * Represents VolumeUnit.
     */
    public enum VolumeUnit implements IMeasurableUnit { LITRE, MILLILITRE, GALLON }
    /**
     * Represents WeightUnit.
     */
    public enum WeightUnit implements IMeasurableUnit { KILOGRAM, GRAM, POUND }
    /**
     * Represents TemperatureUnit.
     */
    public enum TemperatureUnit implements IMeasurableUnit { CELSIUS, FAHRENHEIT }

    /**
     * Property value.
     */
    private double value;
    /**
     * Property unit.
     */
    private IMeasurableUnit unit;

    /**
     * Execution logic for QuantityDTO.
     */
    public QuantityDTO() {}

    /**
     * Execution logic for QuantityDTO.
     */
    public QuantityDTO(double value, IMeasurableUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Execution logic for getValue.
     */
    public double getValue() { return value; }
    /**
     * Execution logic for getUnit.
     */
    public IMeasurableUnit getUnit() { return unit; }
    /**
     * Execution logic for setValue.
     */
    public void setValue(double value) { this.value = value; }
    /**
     * Execution logic for setUnit.
     */
    public void setUnit(IMeasurableUnit unit) { this.unit = unit; }
}
