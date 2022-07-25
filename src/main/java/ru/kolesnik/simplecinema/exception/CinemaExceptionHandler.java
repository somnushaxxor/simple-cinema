package ru.kolesnik.simplecinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kolesnik.simplecinema.payload.ErrorResponse;

@RestControllerAdvice
public class CinemaExceptionHandler {

    @ExceptionHandler(TicketAlreadyPurchasedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse ticketAlreadyPurchasedException(TicketAlreadyPurchasedException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(RowColumnOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse rowColumnOutOfBoundsException(RowColumnOutOfBoundsException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(WrongTokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse wrongTokenException(WrongTokenException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse wrongPasswordException(WrongPasswordException e) {
        return new ErrorResponse(e.getMessage());
    }

}
