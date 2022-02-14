package dev.halilerkan.finalproject.backend.domain.exception;

import lombok.Getter;

@Getter
public class BackendValidationException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public BackendValidationException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public BackendValidationException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

}
