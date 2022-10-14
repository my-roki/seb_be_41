package com.codestates.section2week4.member;

import com.codestates.section2week4.AutoDependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoDependencyConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member(0L, "roki@codestates.com", "roki", "010-1234-5678");
        memberService.createMember(member);

        Member currentMember = memberService.getMember(0L);

        System.out.printf("회원 가입한 유저 : %s%n", member.getName());
        System.out.printf("현재 첫번째 유저 : %s%n", currentMember.getName());

        if (member.getName().equals(currentMember.getName())) {
            System.out.println("새롭게 가입한 사용자와 현재 사용자가 같습니다.");
        }

        memberService.deleteMember(0L);
        if (memberService.getMember(0L) == null) {
            System.out.println("회원 삭제가 정상적으로 완료되었습니다.");
        }
    }
}