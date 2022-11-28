package com.cafe.member.service;

import com.cafe.auth.utils.CustomAuthorityUtils;
import com.cafe.exception.BusinessLogicException;
import com.cafe.exception.ExceptionCode;
import com.cafe.member.entity.Member;
import com.cafe.member.repository.MemberRepository;
import com.cafe.utils.CustomBeanUtils;
import com.cafe.utils.event.MemberRegistrationApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;
    private final CustomBeanUtils<Member> beanUtils;

    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, ApplicationEventPublisher publisher, CustomBeanUtils<Member> beanUtils, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.publisher = publisher;
        this.beanUtils = beanUtils;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    public Member createMember(Member member) {
        verifyMemberExistEmail(member.getEmail());

        if (member.getPassword() != null) {  // password가 null이라는 것은 OAuth2방식 로그인
            String encryptedPassword = passwordEncoder.encode(member.getPassword());
            member.setPassword(encryptedPassword);
        } else {
            member.setPassword("");
        }

        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        Member savedMember = memberRepository.save(member);

        // Event Listener
        // https://sabarada.tistory.com/184
        publisher.publishEvent(new MemberRegistrationApplicationEvent(this, savedMember));

        return savedMember;
    }

    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending()));
    }

    public Member findMember(long memberId) {
        return isMemberExist(memberId);
    }

    public Member updateMember(Member member) {
        Member isMember = isMemberExist(member.getMemberId());
        beanUtils.copyNonNullProperties(member, isMember);

        return memberRepository.save(isMember);
    }

    public void deleteMember(long memberId) {
        Member isMember = isMemberExist(memberId);
        memberRepository.delete(isMember);
    }

    private void verifyMemberExistEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

    public Member isMemberExist(long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}