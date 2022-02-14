package dev.halilerkan.finalproject.backend.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    EMAIL_EXISTS(1001, "This email has already been taken."),
    ID_NO_EXISTS(1002, "This id no has already been taken."),

    CREDIT_SCORE_NOT_FOUND(2001, "Credit score is not found."),
    CUSTOMER_NOT_FOUND(2002, "Customer is not found.");

    private final Integer code;
    private final String message;

}
