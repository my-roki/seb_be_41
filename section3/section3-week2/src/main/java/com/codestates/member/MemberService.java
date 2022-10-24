package com.codestates.member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후, 되돌려 받는걸로 변경 필요
        Member createdMember = member;
        return member;
    }

    public Member updateMember(Member member) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후, 되돌려 받는걸로 변경 필요
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후, 되돌려 받는걸로 변경 필요
        Member member = new Member(memberId, "roki@hello.com", "roki", "010-1234-5678");
        return member;
    }

    public List<Member> findMembers() {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후, 되돌려 받는걸로 변경 필요
        List<Member> members = List.of(
                new Member(1, "roki@hello.com", "roki", "010-1234-5678"),
                new Member(2, "toki@hello.com", "toki", "010-1111-5222278"));
        return members;
    }

    public void deleteMember(long memberId) {
        // TODO should business logic

    }
}