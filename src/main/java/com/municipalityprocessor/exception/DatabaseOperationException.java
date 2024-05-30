package com.municipalityprocessor.exception;

/**
 * Exception thrown when an error occurs during a database operation.
 */
public class DatabaseOperationException extends RuntimeException {
    /**
     * Constructs a new DatabaseOperationException with the specified detail message.
     *
     * @param message the detail message
     */
    public DatabaseOperationException(String message) {
        super(message);
    }

    /**
     * Constructs a new DatabaseOperationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public DatabaseOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
