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
    // Mock data
    // memberId 는 고유한 값
    private long memberId = 0;
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member = new HashMap<>();
        memberId = memberId + 1L;
        member.put("memberId", memberId);
        member.put("email", "roki@hello.com");
        member.put("name", "roki");
        member.put("phone", "010-1234-5678");

        members.put(memberId, member);
    }


    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone) {
        System.out.printf("# email: %s%n", email);
        System.out.printf("# name: %s%n", name);
        System.out.printf("# phone: %s%n", phone);

        Map<String, Object> member = new HashMap<>();
        // memberId 는 고유한 값이므로 생성할때마다 1씩 증가합니다.
        memberId = memberId + 1L;
        member.put("memberId", memberId);
        member.put("email", email);
        member.put("name", name);
        member.put("phone", phone);

        members.put(memberId, member);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        // 조회하려는 멤버가 있는지 확인합니다.
        if (!members.containsKey(memberId)) return new ResponseEntity(HttpStatus.NOT_FOUND);

        Map<String, Object> member = members.get(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestParam(value = "email", required = false) String email,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "phone", required = false) String phone) {

        // 변경하려는 멤버가 있는지 확인합니다.
        if (!members.containsKey(memberId)) return new ResponseEntity(HttpStatus.NOT_FOUND);

        // members 에서 memberId 로 member 를 찾습니다.
        Map<String, Object> member = members.get(memberId);
        if (email != null) member.replace("email", email);
        if (name != null) member.replace("name", name);
        if (phone != null) member.replace("phone", phone);
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