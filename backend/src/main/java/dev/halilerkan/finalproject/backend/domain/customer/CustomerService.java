package dev.halilerkan.finalproject.backend.domain.customer;

import dev.halilerkan.finalproject.backend.adapter.jpa.customer.CustomerEntity;
import dev.halilerkan.finalproject.backend.domain.exception.BackendValidationException;
import dev.halilerkan.finalproject.backend.domain.exception.ExceptionType;
import dev.halilerkan.finalproject.backend.domain.loan.CalculateLoanAmountResponse;
import dev.halilerkan.finalproject.backend.domain.loan.LoanStrategy;
import dev.halilerkan.finalproject.backend.domain.port.CreditscoreApiPort;
import dev.halilerkan.finalproject.backend.domain.port.CustomerPort;
import dev.halilerkan.finalproject.backend.domain.port.SmsApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerPort customerPort;
    private final CreditscoreApiPort creditscoreApiPort;
    private final SmsApiPort smsApiPort;
    private final LoanStrategy loanStrategy;

    public Customer createCustomer(Customer customer) {
        if (Boolean.TRUE.equals(customerPort.isIdNoExists(customer.getIdNo())))
            throw new BackendValidationException(ExceptionType.ID_NO_EXISTS);

        Integer creditScore = creditscoreApiPort.getCreditScore(customer);
        customer.setScore(creditScore);
        customer.addLoanType();

        CalculateLoanAmountResponse response = loanStrategy.calculateLoanAmount(customer);
        customer.addStatusAndLoanAmount(response);

        return customerPort.create(customer);
    }

    public Customer updateCustomer(String idNo, Customer customer) {
        CustomerEntity retrievedCustomerEntity = customerPort.retrieveByIdNo(idNo);
        Integer oldSalary = retrievedCustomerEntity.getSalary();
        CustomerEntity customerEntity = CustomerEntity.valueOf(customer);
        Integer newSalary = customerEntity.getSalary();

        retrievedCustomerEntity.setSalary(customerEntity.getSalary());
        retrievedCustomerEntity.setFirstName(customerEntity.getFirstName());
        retrievedCustomerEntity.setLastName(customerEntity.getLastName());
        retrievedCustomerEntity.setPhoneNumber(customerEntity.getPhoneNumber());
        retrievedCustomerEntity.setUpdatedDate(LocalDateTime.now());

        Customer retrievedCustomer = retrievedCustomerEntity.toCustomer();
        retrievedCustomer.addLoanType();

        if(!oldSalary.equals(newSalary)) {
            CalculateLoanAmountResponse response = loanStrategy.calculateLoanAmount(retrievedCustomer);
            retrievedCustomer.addStatusAndLoanAmount(response);
        }

        return customerPort.update(retrievedCustomerEntity, retrievedCustomer);
    }

    public void deleteCustomer(String idNo) {
        customerPort.deleteByIdNo(idNo);
    }

    public void sendSms(Customer createdCustomer) {
        smsApiPort.sendSms(createdCustomer);
    }

    public Customer retrieveCustomer(String idNo) {
        CustomerEntity retrievedCustomerEntity = customerPort.retrieveByIdNo(idNo);
        Customer retrievedCustomer = retrievedCustomerEntity.toCustomer();
        retrievedCustomer.addLoanType();
        CalculateLoanAmountResponse response = loanStrategy.calculateLoanAmount(retrievedCustomer);
        retrievedCustomer.addStatusAndLoanAmount(response);

        return retrievedCustomer;
    }

}
