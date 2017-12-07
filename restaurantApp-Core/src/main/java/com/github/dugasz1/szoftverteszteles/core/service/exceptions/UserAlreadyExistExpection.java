package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class UserAlreadyExistExpection extends Exception {
    public UserAlreadyExistExpection() {
    }

    public UserAlreadyExistExpection(String message) {
        super(message);
    }

    public UserAlreadyExistExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistExpection(Throwable cause) {
        super(cause);
    }

    public UserAlreadyExistExpection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
