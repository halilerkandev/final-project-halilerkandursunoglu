package dev.halilerkan.finalproject.backend.adapter.jpa.consultant;

import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;
import dev.halilerkan.finalproject.backend.domain.port.ConsultantPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultantJpaAdapter implements ConsultantPort {

    private final ConsultantJpaRepository consultantJpaRepository;

    @Override
    public Consultant create(Consultant consultant) {
        ConsultantEntity consultantEntity = ConsultantEntity.valueOf(consultant);
        return consultantJpaRepository.save(consultantEntity).toConsultant();
    }

    @Override
    public Boolean isEmailExists(String email) {
        return consultantJpaRepository.existsByEmail(email);
    }

}