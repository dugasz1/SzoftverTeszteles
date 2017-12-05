package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoRecipeException extends Exception{

    public NoRecipeException() {
    }

    public NoRecipeException(String s) {
        super(s);
    }

    public NoRecipeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoRecipeException(Throwable throwable) {
        super(throwable);
    }

    public NoRecipeException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
