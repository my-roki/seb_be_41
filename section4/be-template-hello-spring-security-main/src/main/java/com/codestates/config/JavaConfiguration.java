package com.codestates.config;

import com.codestates.auth.HelloAuthorityUtils;
import com.codestates.member.DBMemberService;
import com.codestates.member.MemberRepository;
import com.codestates.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JavaConfiguration {
    @Bean
    public MemberService dbMemberService(MemberRepository memberRepository,
                                         PasswordEncoder passwordEncoder,
                                         HelloAuthorityUtils authorityUtils) {
        return new DBMemberService(memberRepository, passwordEncoder, authorityUtils);
    }
}
