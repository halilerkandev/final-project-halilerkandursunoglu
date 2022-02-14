package dev.halilerkan.finalproject.backend.adapter.rest.customer.request;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UpdateCustomerRequest {

    @Schema(example = "Halil Erkan")
    private String firstName;

    @Schema(example = "Dursunoğlu")
    private String lastName;

    @Schema(example = "1234")
    private Integer salary;

    @Schema(example = "5557778899")
    private String phoneNumber;

    public Customer toCustomer() {
        return Customer.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .salary(getSalary())
                .phoneNumber(getPhoneNumber())
                .build();
    }

}
