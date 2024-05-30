package com.municipalityprocessor.exception;

/**
 * Exception thrown when an error occurs during XML parsing.
 */
public class XmlParsingException extends RuntimeException {
    public XmlParsingException(String message) {
        super(message);
    }

    /**
     * Constructs a new XmlParsingException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public XmlParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}