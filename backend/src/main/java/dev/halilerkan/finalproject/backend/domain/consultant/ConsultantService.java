package dev.halilerkan.finalproject.backend.domain.consultant;

import dev.halilerkan.finalproject.backend.domain.exception.ExceptionType;
import dev.halilerkan.finalproject.backend.domain.exception.BackendValidationException;
import dev.halilerkan.finalproject.backend.domain.port.ConsultantPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultantService {

    private final ConsultantPort consultantPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Consultant create(Consultant consultant) {
        if (Boolean.TRUE.equals(consultantPort.isEmailExists(consultant.getEmail())))
            throw new BackendValidationException(ExceptionType.EMAIL_EXISTS);

        consultant.encodePassword(bCryptPasswordEncoder.encode(consultant.getPassword()));
        return consultantPort.create(consultant);
    }

}
