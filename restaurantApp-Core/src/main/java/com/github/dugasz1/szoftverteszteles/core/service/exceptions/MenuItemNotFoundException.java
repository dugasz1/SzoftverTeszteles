package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class MenuItemNotFoundException  extends Exception  {
    public MenuItemNotFoundException() {
    }

    public MenuItemNotFoundException(String message) {
        super(message);
    }

    public MenuItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuItemNotFoundException(Throwable cause) {
        super(cause);
    }

    public MenuItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
