package quantitymeasurement;

/**
 * Represents LengthUnit.
 */
public enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARD(36.0),
    CM(1.0 / 2.54);

    /**
     * Property baseUnitConversionFactor.
     */
    private final double baseUnitConversionFactor;

    LengthUnit(double baseUnitConversionFactor) {
        this.baseUnitConversionFactor = baseUnitConversionFactor;
    }

    /**
     * Execution logic for convertToBaseUnit.
     */
    public double convertToBaseUnit(double value) {
        return value * this.baseUnitConversionFactor;
    }

    /**
     * Execution logic for convertFromBaseUnit.
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.baseUnitConversionFactor;
    }
}
