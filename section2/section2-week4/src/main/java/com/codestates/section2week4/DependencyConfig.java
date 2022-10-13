package com.codestates.section2week4;

import com.codestates.section2week4.coffee.CoffeeRepository;
import com.codestates.section2week4.coffee.CoffeeService;
import com.codestates.section2week4.member.MemberRepository;
import com.codestates.section2week4.member.MemberService;

// 생성자를 통해 의존성을 주입함으로써 객체가 생성되는 순간 의존관계를 설정할 수 있습니다.
public class DependencyConfig {
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    public CoffeeService coffeeService() {
        return new CoffeeService(coffeeRepository());
    }

    public CoffeeRepository coffeeRepository() {
        return new CoffeeRepository();
    }
}