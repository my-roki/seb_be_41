package com.codestates.config;

import com.codestates.member.InMemoryMemberService;
import com.codestates.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class JavaConfiguration {
    @Bean
    public MemberService inMemoryMemberService(UserDetailsManager userDetailsManager,
                                               PasswordEncoder passwordEncoder) {
        return new InMemoryMemberService(userDetailsManager, passwordEncoder);
    }
}
