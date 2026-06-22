package quantitymeasurement;

import java.util.Objects;

/**
 * Represents QuantityMeasurementApp.
 */
public class QuantityMeasurementApp {

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
         * Execution logic for toBaseUnit.
         */
        public double toBaseUnit(double value) {
            return value * this.baseUnitConversionFactor;
        }
    }

    /**
     * Represents Quantity.
     */
    public static class Quantity {
        /**
         * Property value.
         */
        private final double value;
        /**
         * Property unit.
         */
        private final LengthUnit unit;

        /**
         * Execution logic for Quantity.
         */
        public Quantity(double value, LengthUnit unit) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be a finite number");
            }
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }
            double baseValue = this.unit.toBaseUnit(this.value);
            double convertedValue = baseValue / targetUnit.baseUnitConversionFactor;
            return Math.round(convertedValue * 1000.0) / 1000.0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity quantity = (Quantity) obj;
            double value1 = Math.round(quantity.unit.toBaseUnit(quantity.value) * 1000.0) / 1000.0;
            double value2 = Math.round(this.unit.toBaseUnit(this.value) * 1000.0) / 1000.0;
            return Double.compare(value1, value2) == 0;
        }

        /**
         * Execution logic for hashCode.
         */
        @Override
        public int hashCode() {
            return Objects.hash(unit.toBaseUnit(value));
        }

        /**
         * Execution logic for toString.
         */
        @Override
        public String toString() {
            return "Quantity(" + value + ", \"" + unit.name().toLowerCase() + "\")";
        }
    }

    /**
     * Execution logic for main.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Quantity Measurement App!");
        
        System.out.println("--- Generic Quantity Equality ---");
        Quantity f1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity f2 = new Quantity(1.0, LengthUnit.FEET);
        System.out.println(f1 + " equals " + f2 + ": " + f1.equals(f2));

        Quantity f3 = new Quantity(2.0, LengthUnit.FEET);
        System.out.println(f1 + " equals " + f3 + ": " + f1.equals(f3));

        Quantity i1 = new Quantity(12.0, LengthUnit.INCHES);
        System.out.println(f1 + " equals " + i1 + ": " + f1.equals(i1));
    }
}
