package br.com.devairon.view.exceptions;

public class StudentNullException extends Exception {
    private String message;
    private Throwable cause;

    public StudentNullException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
}
