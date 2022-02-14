package dev.halilerkan.finalproject.backend.adapter.rest.customer.request;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
public class CreateCustomerRequest {

    @Schema(example = "33444555666")
    @NotBlank
    private String idNo;

    @Schema(example = "Halil Erkan")
    @NotBlank
    private String firstName;

    @Schema(example = "Dursunoğlu")
    @NotBlank
    private String lastName;

    @Schema(example = "8500")
    @NotNull
    private Integer salary;

    @Schema(example = "5557778899")
    @NotBlank
    private String phoneNumber;

    public Customer toCustomer() {
        return Customer.builder()
                .idNo(getIdNo())
                .firstName(getFirstName())
                .lastName(getLastName())
                .salary(getSalary())
                .phoneNumber(getPhoneNumber())
                .build();
    }

}
