package com.github.dugasz1.szoftverteszteles.core.exceptions;

/**
 * Thrown when one result is expected but the query arrived with multiplie result
 * TODO: save result in variable
 */
public class MultipleResultException extends Exception {
    public MultipleResultException(String message ){
        super(message);
    }
}
