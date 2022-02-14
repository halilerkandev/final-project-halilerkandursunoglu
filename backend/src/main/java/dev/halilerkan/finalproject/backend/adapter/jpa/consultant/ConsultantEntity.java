package dev.halilerkan.finalproject.backend.adapter.jpa.consultant;

import dev.halilerkan.finalproject.backend.adapter.jpa.common.BaseEntity;
import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "consultant")
@Table(name = "consultant")
public class ConsultantEntity extends BaseEntity {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private Boolean isActive;
    private Boolean isDeleted;

    public static ConsultantEntity valueOf(Consultant consultant) {
        ConsultantEntity consultantEntity = new ConsultantEntity();
        consultantEntity.email = consultant.getEmail();
        consultantEntity.password = consultant.getPassword();
        consultantEntity.firstName = consultant.getFirstName();
        consultantEntity.lastName = consultant.getLastName();
        consultantEntity.role = consultant.getRole();
        consultantEntity.isActive = consultant.getIsActive();
        consultantEntity.isDeleted = consultant.getIsDeleted();
        return consultantEntity;
    }

    public Consultant toConsultant() {
        return Consultant.builder()
                .id(id)
                .email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .role(role)
                .isActive(isActive)
                .isDeleted(isDeleted)
                .build();
    }

}
