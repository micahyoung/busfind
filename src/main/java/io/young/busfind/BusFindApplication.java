package io.young.busfind;

import io.young.busfind.repositories.EstimatesRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BusFindApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusFindApplication.class, args);
    }

    @Bean
    public EstimatesRepository estimateRepository(@Value("${busfind.mtaApiKey}") String apiKey) {
        return new EstimatesRepository(apiKey, new RestTemplate());
    }
}
