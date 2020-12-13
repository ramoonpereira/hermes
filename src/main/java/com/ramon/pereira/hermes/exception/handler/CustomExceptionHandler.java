package com.ramon.pereira.hermes.exception.handler;

import com.ramon.pereira.hermes.exception.ChannelNotFoundException;
import com.ramon.pereira.hermes.exception.CommunicationCanceledException;
import com.ramon.pereira.hermes.exception.CommunicationNotFoundException;
import com.ramon.pereira.hermes.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(CommunicationNotFoundException.class)
    public String exceptionHandler(CommunicationNotFoundException ex) {
        return "Communication NotFound";
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EventNotFoundException.class)
    public String exceptionHandler(EventNotFoundException ex) {
        return "Event NotFound!";
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ChannelNotFoundException.class)
    public String exceptionHandler(ChannelNotFoundException ex) {
        return "Channel NotFound!";
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CommunicationCanceledException.class)
    public String exceptionHandler(CommunicationCanceledException ex) {
        return "Communication Already Canceled!";
    }

}
