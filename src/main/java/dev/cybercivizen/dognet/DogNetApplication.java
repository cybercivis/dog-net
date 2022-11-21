package dev.cybercivizen.dognet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class })
@EnableJpaAuditing
public class DogNetApplication {
    public static void main(String[] args) {
        SpringApplication.run(DogNetApplication.class, args);
    }

}
