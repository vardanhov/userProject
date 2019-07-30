package net.javaguides.springmvc.exception;

public class DataNotFoundException extends Exception {

    private String identifier;

    public DataNotFoundException(String identifier) {
        this.identifier = identifier;
    }

    public DataNotFoundException(String identifier, String message) {
        super(message);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
