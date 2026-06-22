package quantitymeasurement;

/**
 * Represents VolumeUnit.
 */
public enum VolumeUnit implements IMeasurable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    /**
     * Property baseUnitConversionFactor.
     */
    private final double baseUnitConversionFactor;

    VolumeUnit(double baseUnitConversionFactor) {
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

    /**
     * Execution logic for getMeasurementType.
     */
    @Override
    public String getMeasurementType() {
        return "Volume";
    }

    /**
     * Execution logic for getUnitInstance.
     */
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (VolumeUnit unit : VolumeUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName) || unit.getUnitName().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }
        return null;
    }
}
