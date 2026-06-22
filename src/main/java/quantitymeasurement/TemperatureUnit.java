package quantitymeasurement;

import java.util.function.Function;

/**
 * Represents TemperatureUnit.
 */
public enum TemperatureUnit implements IMeasurable {
    CELSIUS(c -> c, c -> c, "celsius"),
    FAHRENHEIT(f -> (f - 32.0) * 5.0 / 9.0, c -> (c * 9.0 / 5.0) + 32.0, "fahrenheit");

    private final Function<Double, Double> toBase;
    private final Function<Double, Double> fromBase;
    /**
     * Property unitName.
     */
    private final String unitName;
    /**
     * Property supportsArithmetic.
     */
    private final SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(Function<Double, Double> toBase, Function<Double, Double> fromBase, String unitName) {
        this.toBase = toBase;
        this.fromBase = fromBase;
        this.unitName = unitName;
    }

    /**
     * Execution logic for getConversionFactor.
     */
    @Override
    public double getConversionFactor() {
        return 1.0; // Not used directly due to custom conversion formulas
    }

    /**
     * Execution logic for convertToBaseUnit.
     */
    @Override
    public double convertToBaseUnit(double value) {
        return toBase.apply(value);
    }

    /**
     * Execution logic for convertFromBaseUnit.
     */
    @Override
    public double convertFromBaseUnit(double baseValue) {
        return fromBase.apply(baseValue);
    }

    /**
     * Execution logic for getUnitName.
     */
    @Override
    public String getUnitName() {
        return unitName;
    }

    /**
     * Execution logic for validateOperationSupport.
     */
    @Override
    public void validateOperationSupport(String operation) {
        if (!supportsArithmetic.isSupported()) {
            throw new UnsupportedOperationException("Temperature measurement does not support " + operation);
        }
    }

    /**
     * Execution logic for getMeasurementType.
     */
    @Override
    public String getMeasurementType() {
        return "Temperature";
    }

    /**
     * Execution logic for getUnitInstance.
     */
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName) || unit.getUnitName().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }
        return null;
    }
}
