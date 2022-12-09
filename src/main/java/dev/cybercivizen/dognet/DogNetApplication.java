package dev.cybercivizen.dognet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(
    scanBasePackages = {"dev.cybercivizen.dognet.mapper",
                        "dev.cybercivizen.dognet.controller",
                        "dev.cybercivizen.dognet.model",
                        "dev.cybercivizen.dognet.repository"}
)

@EnableJpaAuditing
public class DogNetApplication {
    public static void main(String[] args) {
        SpringApplication.run(DogNetApplication.class, args);
    }

}
