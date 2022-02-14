package dev.halilerkan.finalproject.creditscore.domain.creditscore;

import dev.halilerkan.finalproject.creditscore.domain.port.CreditscorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreditscoreService {

    private final CreditscorePort creditscorePort;
    private final Random random = new Random();

    public Creditscore getCreditScoreByIdNo(String idNo) {
        return creditscorePort.retrieveByIdNo(idNo).orElseGet(
                () -> creditscorePort.create(Creditscore.builder()
                            .idNo(idNo)
                            .score(getRandomIntBetweenTwoValues(0, 1500))
                            .build()));
    }

    public Integer getRandomIntBetweenTwoValues(Integer low, Integer high) {
        return random.nextInt(high - low) + low;
    }

}
