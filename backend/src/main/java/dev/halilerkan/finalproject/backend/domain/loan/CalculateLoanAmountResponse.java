package dev.halilerkan.finalproject.backend.domain.loan;

import dev.halilerkan.finalproject.backend.domain.customer.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CalculateLoanAmountResponse {

    private final Status status;
    private final Integer loanAmount;

}
