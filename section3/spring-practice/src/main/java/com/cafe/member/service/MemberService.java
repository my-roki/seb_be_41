package com.cafe.member.service;

import com.cafe.exception.BusinessLogicException;
import com.cafe.exception.ExceptionCode;
import com.cafe.member.entity.Member;
import com.cafe.member.repository.MemberRepository;
import com.cafe.utils.email.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final EmailSender emailSender;

    public MemberService(MemberRepository memberRepository, EmailSender emailSender) {
        this.memberRepository = memberRepository;
        this.emailSender = emailSender;
    }

    public Member createMember(Member member) {
        verifyMemberExistEmail(member.getEmail());

        Member savedMember = memberRepository.save(member);

        // mail sender
        try {
            String[] to = new String[]{savedMember.getEmail()};
            String subject = "Thank you for joining our cafe!";
            String message = savedMember.getEmail() + "님, 회원 가입이 성공적으로 완료되었습니다.";
            String templateName = "email-registration-member";
            emailSender.sendEmail(to, subject, message, templateName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MailSendException: rollback for Member Registration:");
            deleteMember(savedMember.getMemberId());
        }

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