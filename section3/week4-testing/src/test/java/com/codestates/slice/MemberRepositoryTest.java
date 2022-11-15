package com.codestates.slice;

import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveMemberTest() {
        // given
        Member member = new Member();
        member.setEmail("roki@hello.com");
        member.setName("roki");
        member.setPhone("010-1234-5678");

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertNotNull(savedMember);
        assertTrue(member.getEmail().equals(savedMember.getEmail()));
        assertTrue(member.getName().equals(savedMember.getName()));
        assertTrue(member.getPhone().equals(savedMember.getPhone()));
    }

    @Test
    public void findByEmailTest() {
        // given
        Member member = new Member();
        member.setEmail("roki@hello.com");
        member.setName("roki");
        member.setPhone("010-1111-2222");

        // when
        memberRepository.save(member);
        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());

        assertTrue(optionalMember.isPresent());
        assertTrue(optionalMember.get().getEmail().equals(member.getEmail()));
    }
}