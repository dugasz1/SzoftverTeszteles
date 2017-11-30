package com.github.dugasz1.szoftverteszteles.service.dao.exceptions;

public class StorageNotAvailableException extends Exception {
    public StorageNotAvailableException() {
    }

    public StorageNotAvailableException(String message) {
        super(message);
    }

    public StorageNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageNotAvailableException(Throwable cause) {
        super(cause);
    }

    public StorageNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
