package com.codestates.section3week1.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/members")
public class MemberController {
    private final Map<Long, MemberDto> members = new HashMap<>();
    // Mock data
    // memberId 는 고유한 값
    private long memberId = 0;

    @PostConstruct
    public void init() {
        MemberDto member = new MemberDto();
        memberId = memberId + 1L;
        member.setMemberId(memberId);
        member.setEmail("roki@hello.com");
        member.setName("roki");
        member.setPhone("010-1234-5678");

        members.put(memberId, member);
    }

    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto memberDto) {
        System.out.printf("# email: %s%n", memberDto.getEmail());
        System.out.printf("# name: %s%n", memberDto.getName());
        System.out.printf("# phone: %s%n", memberDto.getPhone());

        memberId = memberId + 1L;
        memberDto.setMemberId(memberId);
        members.put(memberId, memberDto);
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        // 조회하려는 멤버가 있는지 확인합니다.
        if (!members.containsKey(memberId)) return new ResponseEntity(HttpStatus.NOT_FOUND);

        MemberDto member = members.get(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberDto memberDto) {

        // 변경하려는 멤버가 있는지 확인합니다.
        if (!members.containsKey(memberId)) return new ResponseEntity(HttpStatus.NOT_FOUND);

        // members 에서 memberId 로 member 를 찾습니다.
        MemberDto member = members.get(memberId);
        if (memberDto.getName() != null) member.setName(memberDto.getName());
        if (memberDto.getPhone() != null) member.setPhone(memberDto.getPhone());
        members.replace(memberId, member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        // 삭제하려는 멤버가 있는지 확인합니다.
        if (!members.containsKey(memberId)) return new ResponseEntity(HttpStatus.NOT_FOUND);

        members.remove(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}