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
        INCHES(1.0);

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
            this.value = value;
            this.unit = unit;
        }

        /**
         * Execution logic for equals.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity quantity = (Quantity) obj;
            return Double.compare(
                quantity.unit.toBaseUnit(quantity.value),
                this.unit.toBaseUnit(this.value)
            ) == 0;
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
