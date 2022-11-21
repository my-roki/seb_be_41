package com.cafe.member.controller;

import com.cafe.member.dto.MemberDto;
import com.cafe.member.entity.Member;
import com.cafe.member.mapper.MemberMapper;
import com.cafe.member.service.MemberService;
import com.cafe.response.MultiResponseDto;
import com.cafe.response.SingleResponseDto;
import com.cafe.stamp.Stamp;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/members")
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post memberPostDto) {
        Member member = mapper.memberPostDtoToMember(memberPostDto);
        member.setStamp(new Stamp());

        Member createdMember = memberService.createMember(member);
        MemberDto.Response response = mapper.memberToMemberResponseDto(createdMember);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {
        Page<Member> memberPage = memberService.findMembers(page - 1, size);
        List<Member> members = memberPage.getContent();
        List<MemberDto.Response> response = mapper.membersToListMemberResponseDto(members);

        return new ResponseEntity<>(new MultiResponseDto<>(response, memberPage), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Min(1) long memberId) {
        Member member = memberService.findMember(memberId);
        MemberDto.Response response = mapper.memberToMemberResponseDto(member);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberDto.Patch memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        Member member = mapper.memberPatchDtoToMember(memberPatchDto);
        Member updateMember = memberService.updateMember(member);
        MemberDto.Response response = mapper.memberToMemberResponseDto(updateMember);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Min(1) long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}