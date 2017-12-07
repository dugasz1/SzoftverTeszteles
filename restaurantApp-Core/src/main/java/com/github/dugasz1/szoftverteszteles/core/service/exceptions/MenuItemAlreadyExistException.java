package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class MenuItemAlreadyExistException extends Exception {
    public MenuItemAlreadyExistException() {
    }

    public MenuItemAlreadyExistException(String message) {
        super(message);
    }

    public MenuItemAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuItemAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public MenuItemAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
