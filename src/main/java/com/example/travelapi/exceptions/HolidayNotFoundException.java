package com.example.travelapi.exceptions;

public class HolidayNotFoundException extends RuntimeException{
    public HolidayNotFoundException(String message) {
        super(message);
    }
}
