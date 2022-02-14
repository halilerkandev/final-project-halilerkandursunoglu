package dev.halilerkan.finalproject.creditscore.domain.port;

import dev.halilerkan.finalproject.creditscore.domain.creditscore.Creditscore;

import java.util.Optional;

public interface CreditscorePort {

    Optional<Creditscore> retrieveByIdNo(String idNo);

    Creditscore create(Creditscore creditscore);

}
