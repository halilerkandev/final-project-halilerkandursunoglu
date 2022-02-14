package dev.halilerkan.finalproject.backend.domain.loan;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoanStrategy {

    private final Map<String, Loan> strategyMap;

    public CalculateLoanAmountResponse calculateLoanAmount(Customer customer) {
        return strategyMap.get(customer.getLoanType().getTypeName()).calculateLoanAmount(customer);
    }

}