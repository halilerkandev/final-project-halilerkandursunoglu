package dev.halilerkan.finalproject.sms.domain.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final TwilioConfig twilioConfig;

    public void sendSms(Sms sms) {
        PhoneNumber to = new PhoneNumber("+90" + sms.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());

        MessageCreator creator = Message.creator(to, from, sms.getMessage());
        creator.create();
    }

}

