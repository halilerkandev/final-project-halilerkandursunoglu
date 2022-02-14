package dev.halilerkan.finalproject.creditscore.adapter.jpa.creditscore;

import dev.halilerkan.finalproject.creditscore.adapter.jpa.common.BaseEntity;
import dev.halilerkan.finalproject.creditscore.domain.creditscore.Creditscore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "creditscore")
@Table(name = "creditscore")
public class CreditscoreEntity extends BaseEntity {

    private String idNo;
    private Integer score;

    public static CreditscoreEntity valueOf(Creditscore creditscore) {
        CreditscoreEntity creditscoreEntity = new CreditscoreEntity();
        creditscoreEntity.idNo = creditscore.getIdNo();
        creditscoreEntity.score = creditscore.getScore();
        return creditscoreEntity;
    }

    public Creditscore toCreditscore() {
        return Creditscore.builder()
                .id(getId())
                .idNo(getIdNo())
                .score(getScore())
                .build();
    }

}
