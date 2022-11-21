package com.codestates.member;

import com.codestates.auth.HelloAuthorityUtils;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Slf4j
public class DBMemberService implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final HelloAuthorityUtils authorityUtils;

    public DBMemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, HelloAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    @Override
    public Member createMember(Member member) {
        verifyExistEmail(member.getEmail());
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // role을 DB에 저장
        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        Member saveMember = memberRepository.save(member);
        log.info("# Create Member in DB : " + saveMember.getMemberId() + " / " + saveMember.getEmail());

        return saveMember;
    }

    @Override
    public Member findMember(String member) {
        return null;
    }

    private void verifyExistEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (optionalMember.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }
}
