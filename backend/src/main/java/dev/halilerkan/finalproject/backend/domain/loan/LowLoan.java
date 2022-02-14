package dev.halilerkan.finalproject.backend.domain.loan;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.customer.Status;
import org.springframework.stereotype.Service;

@Service(LoanType.Name.LOW_LOAN)
public class LowLoan implements Loan {

    @Override
    public CalculateLoanAmountResponse calculateLoanAmount(Customer customer) {
        return CalculateLoanAmountResponse.builder()
                .status(Status.APPROVED)
                .loanAmount(10000).build();
    }

}
