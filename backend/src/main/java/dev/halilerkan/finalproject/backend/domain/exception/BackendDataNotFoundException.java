package dev.halilerkan.finalproject.backend.domain.exception;

import lombok.Getter;

@Getter
public class BackendDataNotFoundException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public BackendDataNotFoundException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public BackendDataNotFoundException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
