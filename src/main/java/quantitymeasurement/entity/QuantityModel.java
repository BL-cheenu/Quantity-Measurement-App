package quantitymeasurement.entity;

import quantitymeasurement.IMeasurable;
import quantitymeasurement.Quantity;

/**
 * Represents QuantityModel.
 */
public class QuantityModel<U extends IMeasurable> {
    /**
     * Property quantity.
     */
    private Quantity<U> quantity;

    /**
     * Execution logic for QuantityModel.
     */
    public QuantityModel(Quantity<U> quantity) {
        this.quantity = quantity;
    }

    /**
     * Execution logic for getQuantity.
     */
    public Quantity<U> getQuantity() {
        return quantity;
    }
}
