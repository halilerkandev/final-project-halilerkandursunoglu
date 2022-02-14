package dev.halilerkan.finalproject.backend.domain.customer;

import dev.halilerkan.finalproject.backend.domain.loan.CalculateLoanAmountResponse;
import dev.halilerkan.finalproject.backend.domain.loan.LoanType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer {

    private Long id;
    private String idNo;
    private String firstName;
    private String lastName;
    private Integer salary;
    private String phoneNumber;
    private Integer score;
    private Status status;
    private Integer loanAmount;
    private LoanType loanType;

    public void addLoanType() {
        if(score < 500) {
            setLoanType(LoanType.REJECTED_LOAN);
        } else if(score < 1000 && salary < 5000) {
            setLoanType(LoanType.LOW_LOAN);
        } else if(score < 1000) {
            setLoanType(LoanType.MEDIUM_LOAN);
        } else {
            setLoanType(LoanType.HIGH_LOAN);
        }
    }

    public void addStatusAndLoanAmount(CalculateLoanAmountResponse response) {
        setStatus(response.getStatus());
        setLoanAmount(response.getLoanAmount());
    }

}
