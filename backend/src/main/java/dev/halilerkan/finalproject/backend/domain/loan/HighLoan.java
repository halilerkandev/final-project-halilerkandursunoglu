package dev.halilerkan.finalproject.backend.domain.loan;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.customer.Status;
import org.springframework.stereotype.Service;

@Service(LoanType.Name.HIGH_LOAN)
public class HighLoan implements Loan {

    @Override
    public CalculateLoanAmountResponse calculateLoanAmount(Customer customer) {
        Integer creditLimitMultiplier = 4;
        return CalculateLoanAmountResponse.builder()
                .status(Status.APPROVED)
                .loanAmount(customer.getSalary() * creditLimitMultiplier).build();
    }

}
