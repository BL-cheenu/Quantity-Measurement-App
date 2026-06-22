package com.app.quantitymeasurement;

/**
 * Represents LengthUnit.
 */
public enum LengthUnit implements IMeasurable {
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
        return "Length";
    }

    /**
     * Execution logic for getUnitInstance.
     */
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (LengthUnit unit : LengthUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName) || unit.getUnitName().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }
        return null;
    }
}
