package ru.kolesnik.simplecinema.exception;

public class TicketAlreadyPurchasedException extends RuntimeException {

    private final String message;

    public TicketAlreadyPurchasedException() {
        this.message = "The ticket has been already purchased!";
    }

    public String getMessage() {
        return message;
    }

}
