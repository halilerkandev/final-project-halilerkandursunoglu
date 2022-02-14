package dev.halilerkan.finalproject.backend.adapter.redis;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.customer.Status;
import dev.halilerkan.finalproject.backend.domain.loan.LoanType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCache {

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

    public static CustomerCache valueOf(Customer customer) {
        return CustomerCache.builder()
                .id(customer.getId())
                .idNo(customer.getIdNo())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .salary(customer.getSalary())
                .phoneNumber(customer.getPhoneNumber())
                .score(customer.getScore())
                .status(customer.getStatus())
                .loanAmount(customer.getLoanAmount())
                .loanType(customer.getLoanType())
                .build();
    }

    public Customer toCustomer() {
        return Customer.builder()
                .id(getId())
                .idNo(getIdNo())
                .firstName(getFirstName())
                .lastName(getLastName())
                .salary(getSalary())
                .phoneNumber(getPhoneNumber())
                .score(getScore())
                .status(getStatus())
                .loanAmount(getLoanAmount())
                .loanType(getLoanType())
                .build();
    }

}
