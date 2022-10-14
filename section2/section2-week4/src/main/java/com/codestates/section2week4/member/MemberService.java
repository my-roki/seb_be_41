package com.codestates.section2week4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
    private final MemberRepository memberRepository;

    // MemberService 는 생성자를 통해 어떤 구현 객체가 주입될지 알 수 없으며, 알 필요도 없습니다.
    // 어떤 객체가 주입될지는 외부(DependencyConfig)에서 결정하게 됩니다. MemberService 는 오로지 실행에만 집중하게 됩니다.
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(Member member) {
        memberRepository.postMember(member);
    }

    public Member getMember(Long memberId) {
        return memberRepository.getMember(memberId);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteMember(memberId);
    }
}