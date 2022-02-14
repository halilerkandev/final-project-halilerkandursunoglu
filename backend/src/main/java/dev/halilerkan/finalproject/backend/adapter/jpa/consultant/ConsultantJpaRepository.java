package dev.halilerkan.finalproject.backend.adapter.jpa.consultant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantJpaRepository extends JpaRepository<ConsultantEntity, Long> {

    Boolean existsByEmail(String email);

}
