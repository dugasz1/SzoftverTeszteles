package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class UserNotFoundExpection extends Exception {
    public UserNotFoundExpection() {
    }

    public UserNotFoundExpection(String message) {
        super(message);
    }

    public UserNotFoundExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundExpection(Throwable cause) {
        super(cause);
    }

    public UserNotFoundExpection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
