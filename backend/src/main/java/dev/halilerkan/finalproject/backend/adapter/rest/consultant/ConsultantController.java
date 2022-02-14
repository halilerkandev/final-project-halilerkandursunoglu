package dev.halilerkan.finalproject.backend.adapter.rest.consultant;

import dev.halilerkan.finalproject.backend.adapter.rest.consultant.request.RegisterRequest;
import dev.halilerkan.finalproject.backend.adapter.rest.consultant.response.RegisterResponse;
import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;
import dev.halilerkan.finalproject.backend.domain.consultant.ConsultantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/consultants")
@RequiredArgsConstructor
@Tag(name = "Consultants")
public class ConsultantController {

    private final ConsultantService consultantService;

    @PostMapping
    @Operation(summary = "Register consultant")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Consultant created"
            )
    })
    public ResponseEntity<RegisterResponse> register(
            @RequestBody @Valid RegisterRequest registerRequest
    ) {
        Consultant consultant = registerRequest.toConsultant();
        Consultant createdConsultant = consultantService.create(consultant);
        RegisterResponse response = RegisterResponse.valueOf(createdConsultant);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}