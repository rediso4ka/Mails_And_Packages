package org.stepic.se.post;

public class StolenPackageException extends RuntimeException{
    public StolenPackageException(String message) {
        super(message);
    }

    public StolenPackageException() {
        super();
    }
}
