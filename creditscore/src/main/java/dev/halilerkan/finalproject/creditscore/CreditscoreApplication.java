package dev.halilerkan.finalproject.creditscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableJpaAuditing
public class CreditscoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditscoreApplication.class, args);
    }

}
