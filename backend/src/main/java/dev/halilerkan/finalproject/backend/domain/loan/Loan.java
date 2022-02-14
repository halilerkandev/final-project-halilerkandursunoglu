package dev.halilerkan.finalproject.backend.domain.loan;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;

public interface Loan {

    CalculateLoanAmountResponse calculateLoanAmount(Customer customer);

}
