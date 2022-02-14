package dev.halilerkan.finalproject.backend.adapter.jpa.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    Boolean existsByIdNo(String idNo);

    Optional<CustomerEntity> findByIdNo(String idNo);

    void deleteByIdNo(String idNo);

}
