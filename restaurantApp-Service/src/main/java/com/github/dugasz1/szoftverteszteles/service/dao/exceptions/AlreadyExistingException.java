package com.github.dugasz1.szoftverteszteles.service.dao.exceptions;

public class AlreadyExistingException extends Exception {
    public AlreadyExistingException() {
    }

    public AlreadyExistingException(String message) {
        super(message);
    }

    public AlreadyExistingException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistingException(Throwable cause) {
        super(cause);
    }

    public AlreadyExistingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
