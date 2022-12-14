package com.codestates.coffee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@RestController
@RequestMapping("v11/coffees")
public class SpringMvcMainCoffeeController {
    private final RestTemplate restTemplate;

    String uri = "http://localhost:7070/v11/coffees/1";

    public SpringMvcMainCoffeeController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        log.info("# call Spring MVC Main Controller: {}", LocalDateTime.now());

        // Rest Template를 이용해서 외부 api에게 한 번 더 요청 후 그 응답을 리턴합니다.
        ResponseEntity<CoffeeResponseDto> response = restTemplate.getForEntity(uri, CoffeeResponseDto.class);
        return ResponseEntity.ok(response.getBody());
    }
}