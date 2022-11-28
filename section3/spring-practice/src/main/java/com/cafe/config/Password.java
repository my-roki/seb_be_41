package com.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


// Security Config에 있으면 일반 jwt로그인과 Oauth2 방식의 로그인이 순환참조가 되어 빌드가 되질 않아 A -> B, B -> C 관계로 분리
@Configuration
public class Password {
    // password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}