package dev.halilerkan.finalproject.sms.adapter.rest.twilio;

import dev.halilerkan.finalproject.sms.domain.twilio.Sms;
import dev.halilerkan.finalproject.sms.domain.twilio.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/twilio")
@RequiredArgsConstructor
public class TwilioController {

    private final SmsService smsService;

    @GetMapping
    public ResponseEntity<Void> sendSms(
            @RequestParam String phoneNumber,
            @RequestParam String message
    ) {
        smsService.sendSms(Sms.builder()
                .phoneNumber(phoneNumber)
                .message(message).build());
        return ResponseEntity.ok().build();
    }

}
