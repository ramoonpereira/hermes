package com.ramon.pereira.hermes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CommunicationCanceledException extends RuntimeException {

    public CommunicationCanceledException() {
        super("Communication Already Canceled!");
    }
}