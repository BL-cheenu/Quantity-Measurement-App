package quantitymeasurement;

/**
 * Represents WeightUnit.
 */
public enum WeightUnit implements IMeasurable {
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
     * Execution logic for getConversionFactor.
     */
    @Override
    public double getConversionFactor() {
        return this.baseUnitConversionFactor;
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

    /**
     * Execution logic for getUnitName.
     */
    @Override
    public String getUnitName() {
        return this.name().toLowerCase();
    }

    @Override
    public String getMeasurementType() {
        return "Weight";
    }

    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (WeightUnit unit : WeightUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName) || unit.getUnitName().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }
        return null;
    }
}
