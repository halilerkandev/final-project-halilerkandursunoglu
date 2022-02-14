package dev.halilerkan.finalproject.backend.adapter.api.creditscore;

import dev.halilerkan.finalproject.backend.adapter.api.creditscore.response.GetCreditScoreResponse;
import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.exception.BackendDataNotFoundException;
import dev.halilerkan.finalproject.backend.domain.exception.ExceptionType;
import dev.halilerkan.finalproject.backend.domain.port.CreditscoreApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditscoreApiAdapter implements CreditscoreApiPort {

    private final RestTemplate restTemplate;

    @Override
    public Integer getCreditScore(Customer customer) {
        GetCreditScoreResponse response =
                restTemplate.getForObject(
                        "http://finalproject-creditscore-api:8083/api/v1/creditscores?idNo=" + customer.getIdNo(),
                        GetCreditScoreResponse.class);
        return Optional.ofNullable(response).map(GetCreditScoreResponse::getScore)
                .orElseThrow(() -> new BackendDataNotFoundException(ExceptionType.CREDIT_SCORE_NOT_FOUND));
    }

}
