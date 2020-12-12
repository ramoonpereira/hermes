package com.ramon.pereira.hermes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ChannelNotFoundException extends RuntimeException {

    public ChannelNotFoundException() {
        super("Channel NotFound!");
    }
}
