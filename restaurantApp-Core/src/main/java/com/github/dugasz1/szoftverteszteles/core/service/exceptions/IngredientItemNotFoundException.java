package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class IngredientItemNotFoundException extends Exception {
    public IngredientItemNotFoundException() {
    }

    public IngredientItemNotFoundException(String message) {
        super(message);
    }

    public IngredientItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientItemNotFoundException(Throwable cause) {
        super(cause);
    }

    public IngredientItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
