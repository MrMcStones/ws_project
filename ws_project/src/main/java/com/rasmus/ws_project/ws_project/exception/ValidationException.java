package com.rasmus.ws_project.ws_project.exception;

// Undantag som används vid valideringsfel
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
