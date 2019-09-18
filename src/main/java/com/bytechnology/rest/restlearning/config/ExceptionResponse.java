package com.bytechnology.rest.restlearning.config;

import java.time.LocalDate;

public class ExceptionResponse {
    private  String message;
    private  String details;
    private LocalDate timestamp;

    public ExceptionResponse(LocalDate timestamp, String message, String details) {
        this.timestamp=timestamp;
        this.message=message;
        this.details=details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }
}
