package com.github.dugasz1.szoftverteszteles.service.dao.exceptions;

public class WrongFormatException extends Exception {
    public WrongFormatException() {
    }

    public WrongFormatException(String message) {
        super(message);
    }

    public WrongFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFormatException(Throwable cause) {
        super(cause);
    }

    public WrongFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
