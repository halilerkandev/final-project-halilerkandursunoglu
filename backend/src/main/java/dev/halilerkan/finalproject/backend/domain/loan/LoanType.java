package dev.halilerkan.finalproject.backend.domain.loan;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoanType {
    REJECTED_LOAN(Name.REJECTED_LOAN),
    LOW_LOAN(Name.LOW_LOAN),
    MEDIUM_LOAN(Name.MEDIUM_LOAN),
    HIGH_LOAN(Name.HIGH_LOAN);

    private final String typeName;

    public interface Name {
        String REJECTED_LOAN = "RejectedLoan";
        String LOW_LOAN = "LowLoan";
        String MEDIUM_LOAN = "MediumLoan";
        String HIGH_LOAN = "HighLoan";
    }
}