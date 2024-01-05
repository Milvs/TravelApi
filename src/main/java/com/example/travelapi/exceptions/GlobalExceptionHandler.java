package com.example.travelapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HolidayNotFoundException.class, LocationNotFoundException.class, ReservationNotFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleCustomApplicationException(
            final RuntimeException ex, final WebRequest request) {
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(), request.getDescription(false));
    }

}
