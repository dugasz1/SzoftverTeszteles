package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoDateException extends Exception {
    public NoDateException() {
    }

    public NoDateException(String s) {
        super(s);
    }

    public NoDateException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoDateException(Throwable throwable) {
        super(throwable);
    }

    public NoDateException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
