package com.github.dugasz1.szoftverteszteles.service.dao.exceptions;

/**
 * Thrown when order is empty or null
 */
public class OrderWrongMapException extends Exception {
    public OrderWrongMapException() {
    }

    public OrderWrongMapException(String message) {
        super(message);
    }

    public OrderWrongMapException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderWrongMapException(Throwable cause) {
        super(cause);
    }

    public OrderWrongMapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
