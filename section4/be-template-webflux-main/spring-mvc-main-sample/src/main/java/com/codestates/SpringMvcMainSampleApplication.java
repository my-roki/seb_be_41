package com.codestates;

import com.codestates.coffee.CoffeeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@SpringBootApplication
public class SpringMvcMainSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcMainSampleApplication.class, args);
    }


    @Bean
    public CommandLineRunner run() {
        return (String... args) -> {
            log.info("### 요청 시작 시간: {}", LocalDateTime.now());

            for (int i = 0; i <= 5; i++) {
                CoffeeResponseDto response = this.getCoffee();
                log.info("coffee name: {} / price: {}", response.getKorName(), response.getPrice());
            }

            log.info("### 요청 종료 시간: {}", LocalDateTime.now());

        };
    }

    private CoffeeResponseDto getCoffee() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/v11/coffees/1";
        ResponseEntity<CoffeeResponseDto> response = restTemplate.getForEntity(uri, CoffeeResponseDto.class);

        return response.getBody();
    }
}
