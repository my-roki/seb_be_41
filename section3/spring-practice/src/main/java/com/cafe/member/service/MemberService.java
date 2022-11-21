package com.cafe.member.service;

import com.cafe.exception.BusinessLogicException;
import com.cafe.exception.ExceptionCode;
import com.cafe.member.entity.Member;
import com.cafe.member.repository.MemberRepository;
import com.cafe.utils.email.EmailSender;
import com.cafe.utils.event.MemberRegistrationApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    public MemberService(MemberRepository memberRepository, ApplicationEventPublisher publisher, EmailSender emailSender) {
        this.memberRepository = memberRepository;
        this.publisher = publisher;
        this.emailSender = emailSender;
    }

    public Member createMember(Member member) {
        verifyMemberExistEmail(member.getEmail());

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

        Optional.ofNullable(member.getName()).ifPresent(isMember::setName);
        Optional.ofNullable(member.getPhone()).ifPresent(isMember::setPhone);
        Optional.ofNullable(member.getMemberStatus()).ifPresent(isMember::setMemberStatus);

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