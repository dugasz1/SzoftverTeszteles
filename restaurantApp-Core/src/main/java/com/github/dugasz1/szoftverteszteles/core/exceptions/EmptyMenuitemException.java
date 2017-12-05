package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class EmptyMenuitemException extends Exception {

    public EmptyMenuitemException() {
    }

    public EmptyMenuitemException(String s) {
        super(s);
    }

    public EmptyMenuitemException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EmptyMenuitemException(Throwable throwable) {
        super(throwable);
    }

    public EmptyMenuitemException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
