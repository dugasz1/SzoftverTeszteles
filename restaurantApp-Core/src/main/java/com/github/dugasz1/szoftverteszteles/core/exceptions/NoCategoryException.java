package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoCategoryException extends Exception {
    public NoCategoryException() {
    }

    public NoCategoryException(String s) {
        super(s);
    }

    public NoCategoryException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoCategoryException(Throwable throwable) {
        super(throwable);
    }

    public NoCategoryException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
