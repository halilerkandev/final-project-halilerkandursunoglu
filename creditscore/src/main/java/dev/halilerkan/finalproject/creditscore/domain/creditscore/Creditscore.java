package dev.halilerkan.finalproject.creditscore.domain.creditscore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Creditscore {

    private Long id;
    private String idNo;
    private Integer score;

}
