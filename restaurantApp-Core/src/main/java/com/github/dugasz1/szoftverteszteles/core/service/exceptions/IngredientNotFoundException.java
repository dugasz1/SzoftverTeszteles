package com.github.dugasz1.szoftverteszteles.core.service.exceptions;

public class IngredientNotFoundException extends  Exception{
    public IngredientNotFoundException() {
    }

    public IngredientNotFoundException(String message) {
        super(message);
    }

    public IngredientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientNotFoundException(Throwable cause) {
        super(cause);
    }

    public IngredientNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
