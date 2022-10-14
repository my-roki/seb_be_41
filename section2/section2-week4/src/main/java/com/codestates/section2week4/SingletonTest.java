package com.codestates.section2week4;

import com.codestates.section2week4.member.MemberService;

public class SingletonTest {
    static DependencyConfig dependencyConfig = new DependencyConfig();

    static MemberService memberService1 = dependencyConfig.memberService();
    static MemberService memberService2 = dependencyConfig.memberService();

    public static void main(String[] args) {
        System.out.printf("memberService1 : %s%n", memberService1);
        System.out.printf("memberService2 : %s%n", memberService2);
    }
}