package com.bytechnology.rest.restlearning.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestException extends RuntimeException {
    public RestException(String message) {
        super(message);
    }
}
