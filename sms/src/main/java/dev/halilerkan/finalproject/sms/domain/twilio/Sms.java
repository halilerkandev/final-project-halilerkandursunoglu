package dev.halilerkan.finalproject.sms.domain.twilio;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Sms {

    private String phoneNumber;
    private String message;

}
