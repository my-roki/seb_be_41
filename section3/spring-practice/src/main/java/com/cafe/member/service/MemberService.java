package com.cafe.member.service;

import com.cafe.exception.BusinessLogicException;
import com.cafe.exception.ExceptionCode;
import com.cafe.member.entity.Member;
import com.cafe.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        verifyMemberExistEmail(member.getEmail());

        return memberRepository.save(member);
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