package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class ExistingProblemException extends Exception {
    public ExistingProblemException() {
    }

    public ExistingProblemException(String message) {
        super(message);
    }

    public ExistingProblemException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingProblemException(Throwable cause) {
        super(cause);
    }

    public ExistingProblemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
