package dev.halilerkan.finalproject.backend.domain.consultant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Consultant {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private Boolean isActive;
    private Boolean isDeleted;

    public void encodePassword(String password) {
        this.password = password;
    }

}
