package com.accountmanagementsystem.backend.exceptions;

public class InvalidRoleException extends Exception {
    public InvalidRoleException() {
        super();
    }

    public InvalidRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRoleException(String message) {
        super(message);
    }

    public InvalidRoleException(Throwable cause) {
        super(cause);
    }
}
