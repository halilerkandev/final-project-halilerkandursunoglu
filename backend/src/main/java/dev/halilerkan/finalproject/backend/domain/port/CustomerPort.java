package dev.halilerkan.finalproject.backend.domain.port;

import dev.halilerkan.finalproject.backend.adapter.jpa.customer.CustomerEntity;
import dev.halilerkan.finalproject.backend.domain.customer.Customer;

public interface CustomerPort {

    Customer create(Customer customer);

    Boolean isIdNoExists(String idNo);

    CustomerEntity retrieveByIdNo(String idNo);

    Customer update(CustomerEntity customerEntity, Customer customer);

    void deleteByIdNo(String idNo);

}
