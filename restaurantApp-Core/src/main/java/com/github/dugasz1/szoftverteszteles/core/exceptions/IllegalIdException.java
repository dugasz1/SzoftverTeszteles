package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class IllegalIdException extends Exception {
    public IllegalIdException() {
    }

    public IllegalIdException(String s) {
        super(s);
    }

    public IllegalIdException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IllegalIdException(Throwable throwable) {
        super(throwable);
    }

    public IllegalIdException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
