package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class NoUserException extends Exception{
    public NoUserException() {
    }

    public NoUserException(String s) {
        super(s);
    }

    public NoUserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoUserException(Throwable throwable) {
        super(throwable);
    }

    public NoUserException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
