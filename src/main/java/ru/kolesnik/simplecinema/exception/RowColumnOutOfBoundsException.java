package ru.kolesnik.simplecinema.exception;

public class RowColumnOutOfBoundsException extends RuntimeException {

    private final String message;

    public RowColumnOutOfBoundsException() {
        this.message = "The number of a row or a column is out of bounds!";
    }

    public String getMessage() {
        return message;
    }

}
