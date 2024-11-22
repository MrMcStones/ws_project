package com.rasmus.ws_project.ws_project.exception;

// Undantag som används när resurs inte kan hittas
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
