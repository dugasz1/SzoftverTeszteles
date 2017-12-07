package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class OrderEmptyOrNullException extends Exception {
    public OrderEmptyOrNullException() {
    }

    public OrderEmptyOrNullException(String message) {
        super(message);
    }

    public OrderEmptyOrNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderEmptyOrNullException(Throwable cause) {
        super(cause);
    }

    public OrderEmptyOrNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
