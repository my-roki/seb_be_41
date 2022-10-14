package com.codestates.section2week4;

import com.codestates.section2week4.coffee.CoffeeRepository;
import com.codestates.section2week4.coffee.CoffeeService;
import com.codestates.section2week4.member.MemberRepository;
import com.codestates.section2week4.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 생성자를 통해 의존성을 주입함으로써 객체가 생성되는 순간 의존관계를 설정할 수 있습니다.
@Configuration
public class DependencyConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Bean
    public CoffeeService coffeeService() {
        return new CoffeeService(coffeeRepository());
    }

    @Bean
    public CoffeeRepository coffeeRepository() {
        return new CoffeeRepository();
    }
}