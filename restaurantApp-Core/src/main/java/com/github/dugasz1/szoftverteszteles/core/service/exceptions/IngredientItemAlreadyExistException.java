package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class IngredientItemAlreadyExistException extends Exception {
    public IngredientItemAlreadyExistException() {
    }

    public IngredientItemAlreadyExistException(String message) {
        super(message);
    }

    public IngredientItemAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientItemAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public IngredientItemAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
