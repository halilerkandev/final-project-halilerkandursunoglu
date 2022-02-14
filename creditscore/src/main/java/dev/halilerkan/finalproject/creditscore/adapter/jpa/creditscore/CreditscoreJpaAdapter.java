package dev.halilerkan.finalproject.creditscore.adapter.jpa.creditscore;

import dev.halilerkan.finalproject.creditscore.domain.creditscore.Creditscore;
import dev.halilerkan.finalproject.creditscore.domain.port.CreditscorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditscoreJpaAdapter implements CreditscorePort {

    private final CreditscoreJpaRepository creditscoreJpaRepository;

    @Override
    public Optional<Creditscore> retrieveByIdNo(String idNo) {
        var ref = new Object() { Creditscore creditscore = null; };
        creditscoreJpaRepository.findByIdNo(idNo).ifPresent(
                creditscoreEntity -> ref.creditscore = creditscoreEntity.toCreditscore());
        return Optional.ofNullable(ref.creditscore);
    }

    @Override
    public Creditscore create(Creditscore creditscore) {
        CreditscoreEntity creditscoreEntity = CreditscoreEntity.valueOf(creditscore);
        return creditscoreJpaRepository.save(creditscoreEntity).toCreditscore();
    }

}
