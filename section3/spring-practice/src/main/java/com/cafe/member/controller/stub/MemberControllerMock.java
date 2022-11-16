package com.cafe.member.controller.stub;

import com.cafe.member.dto.MemberDto;
import com.cafe.member.entity.Member;
import com.cafe.response.MultiResponseDto;
import com.cafe.response.SingleResponseDto;
import com.cafe.stamp.Stamp;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * Note. 1번 방법(지저분하지만 급할때 요긴하게 쓰입니다.) :
 * 실제로 비즈니스 로직이 다 구현되지 않았는데 클라이언트의 요청을 응답해야 하는 상황이 올 수 있습니다.
 * 그럴땐 다음과 같이 Stub Data를 고정적으로 응답해주는 방법으로 클라이언트의 요청을 받아줄 수 있습니다.
 */

//@RestController
//@RequestMapping("/v1/members")
//@Valid
public class MemberControllerMock {
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post memberPostDto) {
        // ! Not implementation

        MemberDto.Response response =
                new MemberDto.Response(
                        1L,
                        "roki@hello.com",
                        "roki",
                        "010-1111-1111",
                        Member.MemberStatus.MEMBER_ACTIVE.getStatus(),
                        new Stamp().getStampCount());

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {
        // ! Not implementation

        List<MemberDto.Response> response = List.of(
                new MemberDto.Response(1L, "roki@hello.com", "roki", "010-1111-1111", Member.MemberStatus.MEMBER_ACTIVE.getStatus(), new Stamp().getStampCount()),
                new MemberDto.Response(2L, "toki@hello.com", "toki", "010-2222-2222", Member.MemberStatus.MEMBER_ACTIVE.getStatus(), new Stamp().getStampCount()));
        PageImpl<MemberDto.Response> memberPage = new PageImpl<>(response, PageRequest.of(0, 10, Sort.by("memberId").descending()), 2);

        return new ResponseEntity<>(new MultiResponseDto<>(response, memberPage), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        MemberDto.Response response = new MemberDto.Response(
                1L,
                "roki@hello.com",
                "roki",
                "010-1111-1111",
                Member.MemberStatus.MEMBER_ACTIVE.getStatus(),
                new Stamp().getStampCount());

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @RequestBody @Valid MemberDto.Patch memberPatchDto) {
        // ! Not implementation

        MemberDto.Response response = new MemberDto.Response(
                1L,
                "roki@hello.com",
                "roki",
                "010-2222-2222",
                Member.MemberStatus.MEMBER_ACTIVE.getStatus(),
                new Stamp().getStampCount());

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        // ! Not implementation

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}