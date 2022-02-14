package dev.halilerkan.finalproject.backend.domain.port;

import dev.halilerkan.finalproject.backend.domain.customer.Customer;

public interface SmsApiPort {

    void sendSms(Customer customer);

}
