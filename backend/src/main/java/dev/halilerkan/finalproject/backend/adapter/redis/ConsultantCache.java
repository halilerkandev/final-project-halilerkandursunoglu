package dev.halilerkan.finalproject.backend.adapter.redis;

import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultantCache {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private Boolean isActive;
    private Boolean isDeleted;

    public static ConsultantCache valueOf(Consultant consultant) {
        return ConsultantCache.builder()
                .id(consultant.getId())
                .email(consultant.getEmail())
                .password(consultant.getPassword())
                .firstName(consultant.getFirstName())
                .lastName(consultant.getLastName())
                .role(consultant.getRole())
                .isActive(consultant.getIsActive())
                .isDeleted(consultant.getIsDeleted())
                .build();
    }

    public Consultant toConsultant() {
        return Consultant.builder()
                .id(getId())
                .email(getEmail())
                .password(getPassword())
                .firstName(getFirstName())
                .lastName(getLastName())
                .role(getRole())
                .isActive(getIsActive())
                .isDeleted(getIsDeleted())
                .build();
    }

}
