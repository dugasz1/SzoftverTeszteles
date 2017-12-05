package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoIngredientItemException extends Exception {
    public NoIngredientItemException() {
    }

    public NoIngredientItemException(String s) {
        super(s);
    }

    public NoIngredientItemException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoIngredientItemException(Throwable throwable) {
        super(throwable);
    }

    public NoIngredientItemException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
