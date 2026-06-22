package quantitymeasurement;

/**
 * Represents WeightUnit.
 */
public enum WeightUnit implements Unit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    /**
     * Property baseUnitConversionFactor.
     */
    private final double baseUnitConversionFactor;

    WeightUnit(double baseUnitConversionFactor) {
        this.baseUnitConversionFactor = baseUnitConversionFactor;
    }

    /**
     * Execution logic for convertToBaseUnit.
     */
    @Override
    public double convertToBaseUnit(double value) {
        return value * this.baseUnitConversionFactor;
    }

    /**
     * Execution logic for convertFromBaseUnit.
     */
    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.baseUnitConversionFactor;
    }
}
