package net.javaguides.springmvc.exception;

public class InternalErrorException extends Exception {

    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(String message, Throwable e) {
        super(message, e);
    }

}
