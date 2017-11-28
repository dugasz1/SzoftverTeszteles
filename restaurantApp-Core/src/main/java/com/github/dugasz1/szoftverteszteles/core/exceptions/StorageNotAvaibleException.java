package com.github.dugasz1.szoftverteszteles.core.exceptions;

public class StorageNotAvaibleException extends Exception {
    public StorageNotAvaibleException() {
    }

    public StorageNotAvaibleException(String s) {
        super(s);
    }

    public StorageNotAvaibleException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StorageNotAvaibleException(Throwable throwable) {
        super(throwable);
    }

    public StorageNotAvaibleException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
