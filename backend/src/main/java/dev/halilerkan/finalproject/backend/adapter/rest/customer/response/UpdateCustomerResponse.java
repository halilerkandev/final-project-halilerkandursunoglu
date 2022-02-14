package dev.halilerkan.finalproject.backend.adapter.rest.customer.response;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.customer.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateCustomerResponse {

    private Status status;
    private Integer loanAmount;

    public static UpdateCustomerResponse valueOf(Customer customer) {
        return UpdateCustomerResponse.builder()
                .status(customer.getStatus())
                .loanAmount(customer.getLoanAmount())
                .build();
    }

}
