package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoIngredientException extends Exception {

    public NoIngredientException() {
    }

    public NoIngredientException(String s) {
        super(s);
    }

    public NoIngredientException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoIngredientException(Throwable throwable) {
        super(throwable);
    }

    public NoIngredientException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
