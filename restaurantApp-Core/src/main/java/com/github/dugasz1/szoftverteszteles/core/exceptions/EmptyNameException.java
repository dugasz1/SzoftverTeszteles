package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class EmptyNameException extends Exception {
    public EmptyNameException() {
    }

    public EmptyNameException(String s) {
        super(s);
    }

    public EmptyNameException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EmptyNameException(Throwable throwable) {
        super(throwable);
    }

    public EmptyNameException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
