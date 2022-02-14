package dev.halilerkan.finalproject.backend.adapter.rest.consultant.response;

import dev.halilerkan.finalproject.backend.domain.consultant.Consultant;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterResponse {

    private Long id;

    public static RegisterResponse valueOf(Consultant consultant) {
        return RegisterResponse.builder()
                .id(consultant.getId())
                .build();
    }

}
