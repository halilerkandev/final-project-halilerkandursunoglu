package dev.halilerkan.finalproject.backend.domain.port;

import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;

public interface ConsultantPort {

    Consultant create(Consultant consultant);

    Boolean isEmailExists(String email);

}
