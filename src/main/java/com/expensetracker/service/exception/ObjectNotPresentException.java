package com.expensetracker.service.exception;

public class ObjectNotPresentException extends Throwable {
    public ObjectNotPresentException(String message) {
        super(message);
    }
}
