package dev.halilerkan.finalproject.backend.adapter.jpa.customer;

import dev.halilerkan.finalproject.backend.adapter.jpa.common.BaseEntity;
import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "customer")
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    private String idNo;
    private String firstName;
    private String lastName;
    private Integer salary;
    private String phoneNumber;
    private Integer score;

    public static CustomerEntity valueOf(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.idNo = customer.getIdNo();
        customerEntity.firstName = customer.getFirstName();
        customerEntity.lastName = customer.getLastName();
        customerEntity.salary = customer.getSalary();
        customerEntity.phoneNumber = customer.getPhoneNumber();
        customerEntity.score = customer.getScore();
        return customerEntity;
    }

    public Customer toCustomer() {
        return Customer.builder()
                .id(id)
                .idNo(idNo)
                .firstName(firstName)
                .lastName(lastName)
                .salary(salary)
                .phoneNumber(phoneNumber)
                .score(score)
                .build();
    }

    public Customer toCustomer(Customer customer) {
        return Customer.builder()
                .id(id)
                .idNo(idNo)
                .firstName(firstName)
                .lastName(lastName)
                .salary(salary)
                .phoneNumber(phoneNumber)
                .score(score)
                .loanAmount(customer.getLoanAmount())
                .status(customer.getStatus())
                .loanType(customer.getLoanType())
                .build();
    }

}
