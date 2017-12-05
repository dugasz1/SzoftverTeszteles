package com.github.dugasz1.szoftverteszteles.service.dao.exceptions;

/**
 * Thrown when one result is expected but the query arrived with multiplie result
 * TODO: save result in variable
 */
public class MultipleResultException extends Exception {
    public MultipleResultException() {
    }

    public MultipleResultException(String message) {
        super(message);
    }

    public MultipleResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultipleResultException(Throwable cause) {
        super(cause);
    }

    public MultipleResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
