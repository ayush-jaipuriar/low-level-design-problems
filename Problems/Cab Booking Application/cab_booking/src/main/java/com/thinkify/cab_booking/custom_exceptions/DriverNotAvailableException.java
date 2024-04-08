package com.thinkify.cab_booking.custom_exceptions;

public class DriverNotAvailableException extends RuntimeException {
    public DriverNotAvailableException(String message) {
        super(message);
    }

}
