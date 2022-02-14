package dev.halilerkan.finalproject.backend.domain.loan;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.customer.Status;
import org.springframework.stereotype.Service;

@Service(LoanType.Name.REJECTED_LOAN)
public class RejectedLoan implements Loan {

    @Override
    public CalculateLoanAmountResponse calculateLoanAmount(Customer customer) {
        return CalculateLoanAmountResponse.builder()
                .status(Status.REJECTED)
                .loanAmount(0).build();
    }

}
