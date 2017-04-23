package io.young.busfind;

import io.young.busfind.repositories.EstimatesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BusFindApplication {

    @Bean
    public EstimatesRepository estimateRepository() {
        return new EstimatesRepository();
    }

    public static void main(String[] args) {

        SpringApplication.run(BusFindApplication.class, args);
    }


}
