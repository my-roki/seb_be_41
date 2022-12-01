package com.codestates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories  // R2DBC Repository 사용
@EnableR2dbcAuditing  // 공통 컬럼 자동 저장
@SpringBootApplication
public class Section4Week4TemplateWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(Section4Week4TemplateWebfluxApplication.class, args);
    }


    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }
}
