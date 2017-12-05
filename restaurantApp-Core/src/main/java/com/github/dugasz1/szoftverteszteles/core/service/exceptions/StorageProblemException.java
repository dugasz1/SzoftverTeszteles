package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class StorageProblemException extends Exception {
    public StorageProblemException() {
    }

    public StorageProblemException(String message) {
        super(message);
    }

    public StorageProblemException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageProblemException(Throwable cause) {
        super(cause);
    }

    public StorageProblemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
