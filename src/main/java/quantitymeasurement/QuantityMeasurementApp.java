package quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    /**
     * Inner class representing a measurement in Feet.
     */
    public static class Feet {
        /**
         * The numeric value of feet.
         */
        private final double value;

        /**
         * Constructor to initialize Feet with a given value.
         * @param value The value in feet.
         */
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Compares this Feet object with another for equality based on their values.
         * @param obj The object to compare with.
         * @return true if both objects are of type Feet and have the same value.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, value) == 0;
        }

        /**
         * Generates a hash code for this Feet object.
         * @return The hash code.
         */
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    /**
     * The main method to demonstrate the equality check of Feet objects.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Quantity Measurement App!");
        
        // Example usage for UC1
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        System.out.println("0 Feet equals 0 Feet: " + feet1.equals(feet2));
    }
}
