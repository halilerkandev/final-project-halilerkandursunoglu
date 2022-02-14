package dev.halilerkan.finalproject.backend.adapter.rest.consultant.request;

import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
public class RegisterRequest {

    @Schema(example = "halilerkandev@gmail.com")
    @NotBlank
    private String email;

    @Schema(example = "123456")
    @NotBlank
    private String password;

    @Schema(example = "Halil Erkan")
    @NotBlank
    private String firstName;

    @Schema(example = "Dursunoğlu")
    @NotBlank
    private String lastName;

    @Schema(example = "CONSULTANT")
    @NotBlank
    private String role;

    public Consultant toConsultant() {
        return Consultant.builder()
                .email(getEmail())
                .password(getPassword())
                .firstName(getFirstName())
                .lastName(getLastName())
                .role(getRole())
                .isActive(true)
                .isDeleted(false)
                .build();
    }

}
