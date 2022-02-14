package dev.halilerkan.finalproject.sms.domain.twilio;

import com.twilio.Twilio;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfig {

    private String accountSid;
    private String authToken;
    private String trialNumber;

    @Bean
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

}