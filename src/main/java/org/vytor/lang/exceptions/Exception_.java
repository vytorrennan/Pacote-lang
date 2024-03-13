package org.vytor.lang.exceptions;

public class Exception_ {

    String exceptionName;
    String details;

    public Exception_(String exceptionName, String details) {
        this.exceptionName = exceptionName;
        this.details = details;
    }

    @Override
    public String toString() {
        return this.exceptionName + " : " + "Details: " + this.details;
    }
}
