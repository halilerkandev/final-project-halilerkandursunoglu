package dev.halilerkan.finalproject.backend.adapter.api.sms;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;
import dev.halilerkan.finalproject.backend.domain.loan.LoanType;
import dev.halilerkan.finalproject.backend.domain.port.SmsApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SmsApiAdapter implements SmsApiPort {

    private final RestTemplate restTemplate;

    @Override
    public void sendSms(Customer customer) {
        String message;

        if (customer.getLoanType().equals(LoanType.REJECTED_LOAN)) {
            message = "Sayın " + customer.getFirstName() + " " + customer.getLastName() +
                    ". Maalesef kredi başvurunuza olumlu dönüş yapamıyoruz." +
            " Lütfen ilerleyen zamanlarda tekrar başvurmayı unutmayın.";
        } else {
            message = "Sayın " + customer.getFirstName() + " " + customer.getLastName() +
                    ". Kredi başvurunuz onaylandı. Adınıza tanımlanan kredi limitiniz: " +
            customer.getLoanAmount() + "TL'dir. Lütfen en kısa zamanda size en yakın şubemizle" +
            " iletişime geçmeyi unutmayınız.";
        }

        restTemplate.getForObject("http://finalproject-sms-api:8084/api/v1/twilio?phoneNumber=" +
                                customer.getPhoneNumber() +
                                "&message=" + message, Void.class);
    }

}
