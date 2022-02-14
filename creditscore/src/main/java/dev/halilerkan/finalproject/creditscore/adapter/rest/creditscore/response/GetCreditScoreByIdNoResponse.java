package dev.halilerkan.finalproject.creditscore.adapter.rest.creditscore.response;

import dev.halilerkan.finalproject.creditscore.domain.creditscore.Creditscore;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCreditScoreByIdNoResponse {

    private Integer score;

    public static GetCreditScoreByIdNoResponse valueOf(Creditscore creditscore) {
        return GetCreditScoreByIdNoResponse.builder()
                .score(creditscore.getScore())
                .build();
    }

}
