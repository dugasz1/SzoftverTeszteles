package com.github.dugasz1.szoftverteszteles.service;

public class AlreadyExistingException extends Exception {
    public AlreadyExistingException() {
    }

    public AlreadyExistingException(String s) {
        super(s);
    }
}
