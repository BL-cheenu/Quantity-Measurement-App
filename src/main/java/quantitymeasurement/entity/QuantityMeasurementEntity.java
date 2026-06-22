package quantitymeasurement.entity;

import java.io.Serializable;

/**
 * Represents QuantityMeasurementEntity.
 */
public class QuantityMeasurementEntity implements Serializable {
    /**
     * Property serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Property operand1.
     */
    private QuantityDTO operand1;
    /**
     * Property operand2.
     */
    private QuantityDTO operand2;
    /**
     * Property operationType.
     */
    private String operationType;
    /**
     * Property result.
     */
    private String result;
    /**
     * Property hasError.
     */
    private boolean hasError;
    /**
     * Property errorMessage.
     */
    private String errorMessage;

    // Single operand operation (e.g. conversion)
    public QuantityMeasurementEntity(QuantityDTO operand1, String operationType, String result) {
        this.operand1 = operand1;
        this.operationType = operationType;
        this.result = result;
        this.hasError = false;
    }

    // Binary operation
    public QuantityMeasurementEntity(QuantityDTO operand1, QuantityDTO operand2, String operationType, String result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operationType = operationType;
        this.result = result;
        this.hasError = false;
    }

    // Error
    public QuantityMeasurementEntity(String operationType, String errorMessage) {
        this.operationType = operationType;
        this.hasError = true;
        this.errorMessage = errorMessage;
    }

    /**
     * Execution logic for getOperand1.
     */
    public QuantityDTO getOperand1() { return operand1; }
    /**
     * Execution logic for getOperand2.
     */
    public QuantityDTO getOperand2() { return operand2; }
    /**
     * Execution logic for getOperationType.
     */
    public String getOperationType() { return operationType; }
    /**
     * Execution logic for getResult.
     */
    public String getResult() { return result; }
    /**
     * Execution logic for hasError.
     */
    public boolean hasError() { return hasError; }
    /**
     * Execution logic for getErrorMessage.
     */
    public String getErrorMessage() { return errorMessage; }

    /**
     * Execution logic for toString.
     */
    @Override
    public String toString() {
        if (hasError) {
            return "Operation: " + operationType + " | Error: " + errorMessage;
        }
        if (operand2 == null) {
            return "Operation: " + operationType + " | Operand1: " + operand1.getValue() + " " + operand1.getUnit() + " | Result: " + result;
        }
        return "Operation: " + operationType + " | Operand1: " + operand1.getValue() + " " + operand1.getUnit() + " | Operand2: " + operand2.getValue() + " " + operand2.getUnit() + " | Result: " + result;
    }
}
