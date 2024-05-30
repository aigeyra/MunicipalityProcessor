package com.municipalityprocessor.exception;

/**
 * Exception thrown when an error occurs during XML unzip.
 */
public class XmlUnzipException extends RuntimeException {

    /**
     * Constructs a new XmlUnzipException with the specified detail message.
     *
     * @param message the detail message
     */
    public XmlUnzipException(String message) {
        super(message);
    }

    /**
     * Constructs a new XmlUnzipException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public XmlUnzipException(String message, Throwable cause) {
        super(message, cause);
    }
}