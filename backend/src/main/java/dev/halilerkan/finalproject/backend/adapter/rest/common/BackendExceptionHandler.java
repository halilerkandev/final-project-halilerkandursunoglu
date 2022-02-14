package dev.halilerkan.finalproject.backend.adapter.rest.common;

import dev.halilerkan.finalproject.backend.domain.exception.BackendDataNotFoundException;
import dev.halilerkan.finalproject.backend.domain.exception.BackendValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BackendExceptionHandler {

    @ExceptionHandler(BackendDataNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResponse handleDataNotFoundException(BackendDataNotFoundException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }

    @ExceptionHandler(BackendValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleValidationException(BackendValidationException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }

}

