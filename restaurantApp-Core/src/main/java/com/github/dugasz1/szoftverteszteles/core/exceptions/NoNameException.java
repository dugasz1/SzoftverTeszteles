package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoNameException extends Exception {
    public NoNameException() {
    }

    public NoNameException(String s) {
        super(s);
    }

    public NoNameException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoNameException(Throwable throwable) {
        super(throwable);
    }

    public NoNameException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
