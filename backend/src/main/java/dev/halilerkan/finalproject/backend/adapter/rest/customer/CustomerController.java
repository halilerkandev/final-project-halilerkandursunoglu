package dev.halilerkan.finalproject.backend.adapter.rest.customer;

import dev.halilerkan.finalproject.backend.adapter.rest.customer.request.CreateCustomerRequest;
import dev.halilerkan.finalproject.backend.adapter.rest.customer.request.UpdateCustomerRequest;
import dev.halilerkan.finalproject.backend.adapter.rest.customer.response.CreateCustomerResponse;
import dev.halilerkan.finalproject.backend.adapter.rest.customer.response.RetrieveCustomerResponse;
import dev.halilerkan.finalproject.backend.adapter.rest.customer.response.UpdateCustomerResponse;
import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Create customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Customer created"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content()
            )
    })
    public ResponseEntity<CreateCustomerResponse> createCustomer(
            @RequestBody @Valid CreateCustomerRequest createCustomerRequest
    ) {
        Customer customer = createCustomerRequest.toCustomer();
        Customer createdCustomer = customerService.createCustomer(customer);
        customerService.sendSms(createdCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateCustomerResponse.valueOf(createdCustomer));
    }

    @GetMapping("/{idNo}")
    @Operation(summary = "Retrieve customer by idendity no")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Customer retrieved"
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Unprocessable Entity",
                    content = @Content()
            )
    })
    public ResponseEntity<RetrieveCustomerResponse> retrieveCustomer(
            @PathVariable String idNo
    ) {
        Customer customer = customerService.retrieveCustomer(idNo);
        return ResponseEntity.ok(RetrieveCustomerResponse.valueOf(customer));
    }

    @PutMapping("/{idNo}")
    @Operation(summary = "Update customer by idendity no")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Customer updated"
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Unprocessable Entity",
                    content = @Content()
            )
    })
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(
            @PathVariable String idNo,
            @RequestBody @Valid UpdateCustomerRequest updateCustomerRequest
    ) {
        Customer customer = updateCustomerRequest.toCustomer();
        Customer updatedCustomer = customerService.updateCustomer(idNo, customer);
        return ResponseEntity.ok(UpdateCustomerResponse.valueOf(updatedCustomer));
    }

    @DeleteMapping("/{idNo}")
    @Operation(summary = "Delete customer by idendity no")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "No content",
                    content = @Content()
            )
    })
    public ResponseEntity<Void> deleteCustomer(@PathVariable String idNo) {
        customerService.deleteCustomer(idNo);
        return ResponseEntity.noContent().build();
    }

}