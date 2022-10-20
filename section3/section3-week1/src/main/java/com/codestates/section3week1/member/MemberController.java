package com.codestates.section3week1.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MemberController {
    @PostMapping
    public String postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
        System.out.printf("# email: %s%n", email);
        System.out.printf("# name: %s%n", name);
        System.out.printf("# phone: %s%n", phone);

        String response = "{\"" +
                "email\":\"" + email + "\"," +
                "\"name\":\"" + name + "\",\"" +
                "phone\":\"" + phone + "\"}";
        return response;
    }

    @GetMapping
    public String getMembers() {
        System.out.println("# get Members");

        // not implementation
        return null;
    }

    @GetMapping("/{member-id}")
    public String getMember(@PathVariable("member-id") long memberId) {
        System.out.printf("# memberId: %d%n", memberId);

        // not implementation
        return null;
    }
}