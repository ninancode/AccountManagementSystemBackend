package com.accountmanagementsystem.backend.exceptions;

public class InvalidBankAccountException extends Exception{
    public InvalidBankAccountException() {
        super();
    }

    public InvalidBankAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBankAccountException(String message) {
        super(message);
    }

    public InvalidBankAccountException(Throwable cause) {
        super(cause);
    }
}

