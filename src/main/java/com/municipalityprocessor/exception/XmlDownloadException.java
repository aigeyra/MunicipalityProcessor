package com.municipalityprocessor.exception;
/**
 * Exception thrown when an error occurs during XML download.
 */
public class XmlDownloadException extends RuntimeException {

    /**
     * Constructs a new XmlDownloadException with the specified detail message.
     *
     * @param message the detail message
     */
    public XmlDownloadException(String message) {
        super(message);
    }

    /**
     * Constructs a new XmlDownloadException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public XmlDownloadException(String message, Throwable cause) {
        super(message, cause);
    }
}