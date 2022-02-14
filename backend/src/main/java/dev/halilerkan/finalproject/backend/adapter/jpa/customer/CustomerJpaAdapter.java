package dev.halilerkan.finalproject.backend.adapter.jpa.customer;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.exception.BackendDataNotFoundException;
import dev.halilerkan.finalproject.backend.domain.exception.ExceptionType;
import dev.halilerkan.finalproject.backend.domain.port.CustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerJpaAdapter implements CustomerPort {

    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public Customer create(Customer customer) {
        CustomerEntity customerEntity = CustomerEntity.valueOf(customer);
        return customerJpaRepository.save(customerEntity).toCustomer(customer);
    }

    @Override
    public Boolean isIdNoExists(String idNo) {
        return customerJpaRepository.existsByIdNo(idNo);
    }

    @Override
    public CustomerEntity retrieveByIdNo(String idNo) {
        return customerJpaRepository.findByIdNo(idNo)
                .orElseThrow(() -> new BackendDataNotFoundException(ExceptionType.CUSTOMER_NOT_FOUND));
    }

    @Override
    public Customer update(CustomerEntity customerEntity, Customer customer) {
        return customerJpaRepository.save(customerEntity).toCustomer(customer);
    }

    @Override
    public void deleteByIdNo(String idNo) {
        customerJpaRepository.deleteByIdNo(idNo);
    }

}