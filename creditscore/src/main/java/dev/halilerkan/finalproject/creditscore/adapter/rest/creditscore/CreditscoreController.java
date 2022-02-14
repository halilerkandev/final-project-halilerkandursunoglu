package dev.halilerkan.finalproject.creditscore.adapter.rest.creditscore;

import dev.halilerkan.finalproject.creditscore.adapter.rest.creditscore.response.GetCreditScoreByIdNoResponse;
import dev.halilerkan.finalproject.creditscore.domain.creditscore.Creditscore;
import dev.halilerkan.finalproject.creditscore.domain.creditscore.CreditscoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/creditscores")
@RequiredArgsConstructor
public class CreditscoreController {

    private final CreditscoreService creditscoreService;

    @GetMapping
    public ResponseEntity<GetCreditScoreByIdNoResponse> getCreditScoreByIdNo(
            @RequestParam String idNo
    ) {
        Creditscore creditscore = creditscoreService.getCreditScoreByIdNo(idNo);
        return ResponseEntity.status(HttpStatus.OK).body(GetCreditScoreByIdNoResponse.valueOf(creditscore));
    }

}