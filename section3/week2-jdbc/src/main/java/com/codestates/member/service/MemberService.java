package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    // MemberRepository DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        // 이미 등록된 이메일인지 검증
        verifyExistEmail(member.getEmail());

        // 회원 정보 저장
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        // 존재하는 회원인지 검증
        Member findMember = findVerifiedMember(member.getMemberId());

        // 이름 정보와 휴대폰 정보 업데이트
        Optional.ofNullable(member.getName()).ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone()).ifPresent(phone -> findMember.setPhone(phone));

        // 회원 정보 업데이트
        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {
        // 특정 회원 정보 조회
        return findVerifiedMember(memberId);
    }

    public List<Member> findMembers() {
        // 모든 회원 정보 조회
        return (List<Member>) memberRepository.findAll();
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);

        // 특정회원 정보 삭제
        memberRepository.delete(findMember);
    }

    // 이미 존재하는 회원인지 검증
    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    // 이미 등록된 이메일인지 검증
    public void verifyExistEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);

        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
