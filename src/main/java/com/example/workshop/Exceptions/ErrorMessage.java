package com.example.workshop.Exceptions;

public class ErrorMessage {
    public String getMessage() {
        return message;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "message='" + message + '\'' +
                '}';
    }

    private String message ;
}
