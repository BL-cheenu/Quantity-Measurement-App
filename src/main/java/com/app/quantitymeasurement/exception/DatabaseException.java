package com.app.quantitymeasurement.exception;

/**
 * Represents DatabaseException.
 */
public class DatabaseException extends RuntimeException {
    /**
     * Execution logic for DatabaseException.
     */
    public DatabaseException(String message) {
        super(message);
    }

    /**
     * Execution logic for DatabaseException.
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
