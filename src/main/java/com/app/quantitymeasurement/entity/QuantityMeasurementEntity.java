package com.app.quantitymeasurement.entity;

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
     * Property id.
     */
    private Long id;
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
    /**
     * Property measurementType.
     */
    private String measurementType;

    /**
     * Execution logic for QuantityMeasurementEntity.
     */
    public QuantityMeasurementEntity() {}

    // Single operand operation (e.g. conversion)
    public QuantityMeasurementEntity(QuantityDTO operand1, String operationType, String result) {
        this.operand1 = operand1;
        this.operationType = operationType;
        this.result = result;
        this.hasError = false;
        if (operand1 != null) {
            this.measurementType = operand1.getUnit().getClass().getSimpleName().replace("Unit", "").toUpperCase();
        }
    }

    // Binary operation
    public QuantityMeasurementEntity(QuantityDTO operand1, QuantityDTO operand2, String operationType, String result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operationType = operationType;
        this.result = result;
        this.hasError = false;
        if (operand1 != null) {
            this.measurementType = operand1.getUnit().getClass().getSimpleName().replace("Unit", "").toUpperCase();
        }
    }

    // Error
    public QuantityMeasurementEntity(String operationType, String errorMessage) {
        this.operationType = operationType;
        this.hasError = true;
        this.errorMessage = errorMessage;
    }

    /**
     * Execution logic for getId.
     */
    public Long getId() { return id; }
    /**
     * Execution logic for setId.
     */
    public void setId(Long id) { this.id = id; }
    /**
     * Execution logic for getOperand1.
     */
    public QuantityDTO getOperand1() { return operand1; }
    /**
     * Execution logic for setOperand1.
     */
    public void setOperand1(QuantityDTO operand1) { this.operand1 = operand1; }
    /**
     * Execution logic for getOperand2.
     */
    public QuantityDTO getOperand2() { return operand2; }
    /**
     * Execution logic for setOperand2.
     */
    public void setOperand2(QuantityDTO operand2) { this.operand2 = operand2; }
    /**
     * Execution logic for getOperationType.
     */
    public String getOperationType() { return operationType; }
    /**
     * Execution logic for setOperationType.
     */
    public void setOperationType(String operationType) { this.operationType = operationType; }
    /**
     * Execution logic for getOperation.
     */
    public String getOperation() { return operationType; }
    /**
     * Execution logic for setOperation.
     */
    public void setOperation(String operation) { this.operationType = operation; }
    /**
     * Execution logic for getResult.
     */
    public String getResult() { return result; }
    /**
     * Execution logic for setResult.
     */
    public void setResult(String result) { this.result = result; }
    /**
     * Execution logic for hasError.
     */
    public boolean hasError() { return hasError; }
    /**
     * Execution logic for setHasError.
     */
    public void setHasError(boolean hasError) { this.hasError = hasError; }
    /**
     * Execution logic for getErrorMessage.
     */
    public String getErrorMessage() { return errorMessage; }
    /**
     * Execution logic for setErrorMessage.
     */
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    /**
     * Execution logic for getMeasurementType.
     */
    public String getMeasurementType() { return measurementType; }
    /**
     * Execution logic for setMeasurementType.
     */
    public void setMeasurementType(String measurementType) { this.measurementType = measurementType; }
    
    /**
     * Execution logic for getOperand1Value.
     */
    public double getOperand1Value() { return operand1 != null ? operand1.getValue() : 0.0; }
    /**
     * Execution logic for getOperand1Unit.
     */
    public String getOperand1Unit() { return operand1 != null ? operand1.getUnit().toString() : null; }
    /**
     * Execution logic for getOperand2Value.
     */
    public double getOperand2Value() { return operand2 != null ? operand2.getValue() : 0.0; }
    /**
     * Execution logic for getOperand2Unit.
     */
    public String getOperand2Unit() { return operand2 != null ? operand2.getUnit().toString() : null; }
    
    /**
     * Execution logic for setOperand1Value.
     */
    public void setOperand1Value(double v) {}
    /**
     * Execution logic for setOperand1Unit.
     */
    public void setOperand1Unit(String u) {}
    /**
     * Execution logic for setOperand2Value.
     */
    public void setOperand2Value(double v) {}
    /**
     * Execution logic for setOperand2Unit.
     */
    public void setOperand2Unit(String u) {}

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
