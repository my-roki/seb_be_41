package com.codestates.restdocs;

import com.codestates.member.controller.MemberController;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.codestates.util.ApiDocumentUtil.getRequestPreProcessor;
import static com.codestates.util.ApiDocumentUtil.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MemberController.class)  // Note. @WebMvcTest 애너테이션은 Controller를 테스트 하기 위한 전용 애너테이션
@MockBean(JpaMetamodelMappingContext.class)  // Note. JPA에서 사용하는 Bean들을 Mock 객체로 주입해주는 설정
@AutoConfigureRestDocs // Note. Spring Rest Docs에 대한 자동 구성을 위해 @AutoConfigureRestDocs를 추가
public class MemberControllerRestDocsTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Autowired
    private Gson gson;

    @Test
    public void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = new MemberDto.Post("roki@hello.com", "roki", "010-1111-2222");
        MemberDto.response response = new MemberDto.response(
                1L,
                "roki@hello.com",
                "roki",
                "010-1111-2222",
                Member.MemberStatus.MEMBER_ACTIVE,
                new Stamp());

        String content = gson.toJson(post);

        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                post("/v11/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        // then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andDo(document("post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }

    @Test
    public void patchMemberTest() throws Exception {
        // given
        long memberId = 1L;

        MemberDto.Patch patch = new MemberDto.Patch(memberId, "toki", "010-9999-8888", Member.MemberStatus.MEMBER_ACTIVE);
        String content = gson.toJson(patch);

        MemberDto.response response = new MemberDto.response(
                memberId,
                "roki@hello.com",
                "toki",
                "010-9999-8888",
                Member.MemberStatus.MEMBER_ACTIVE,
                new Stamp());

        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());
        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                patch("/v11/members/{member-id}", memberId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.name").value(patch.getName()))
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(patch.getMemberStatus().getStatus()))
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),    // (2)
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름").optional(),    // (3)
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호").optional(),
                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_ACTIVE / MEMBER_SLEEP / MEMBER_QUIT").optional()
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면 상태 / 탈퇴 상태\""),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));

    }

    @Test
    public void getMembersTest() throws Exception {
        // given
        Member roki = new Member("roki@hello.com", "roki", "010-1111-1111");
        roki.setStamp(new Stamp());
        roki.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);

        Member toki = new Member("toki@hello.com", "toki", "010-1111-1111");
        toki.setStamp(new Stamp());
        toki.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);

        Member poki = new Member("poki@hello.com", "poki", "010-1111-1111");
        poki.setStamp(new Stamp());
        poki.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);

        PageImpl<Member> members = new PageImpl<>(List.of(roki, toki, poki),
                PageRequest.of(0, 10, Sort.by("memberId").descending()),
                3);

        List<MemberDto.response> response = List.of(
                new MemberDto.response(1L, "roki@hello.com", "roki", "010-1111-1111", Member.MemberStatus.MEMBER_ACTIVE, new Stamp()),
                new MemberDto.response(2L, "toki@hello.com", "toki", "010-2222-2222", Member.MemberStatus.MEMBER_ACTIVE, new Stamp()),
                new MemberDto.response(3L, "poki@hello.com", "poki", "010-3333-3333", Member.MemberStatus.MEMBER_ACTIVE, new Stamp())
        );

        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);
        given(mapper.membersToMemberResponses(Mockito.anyList())).willReturn(response);

        // when
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", String.valueOf(1));
        queryParams.add("size", String.valueOf(10));

        ResultActions actions = mockMvc.perform(get("/v11/members")
                .params(queryParams)
                .accept(MediaType.APPLICATION_JSON));

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andDo(document(
                        "get-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(List.of(
                                parameterWithName("page").description("페이지 번호"),
                                parameterWithName("size").description("페이지 내 개수")
                        )),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                        fieldWithPath("data[0].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data[0].email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data[0].name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data[0].phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data[0].memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면 상태 / 탈퇴 상태"),
                                        fieldWithPath("data[0].stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수"),
                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 번호"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 내 개수"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 회원수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지수")
                                )
                        )

                ));
    }

    @Test
    public void getMemberTest() throws Exception {
        // given
        long memberId = 1L;
        Member member = new Member("roki@hello.com", "roki", "010-1111-1111");
        member.setMemberId(memberId);
        member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member.setStamp(new Stamp());

        MemberDto.response response = new MemberDto.response(memberId, "roki@hello.com", "roki", "010-1111-1111", Member.MemberStatus.MEMBER_ACTIVE, new Stamp());

        given(memberService.findMember(Mockito.anyLong())).willReturn(member);
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                get("/v11/members/{member-id}", memberId)
                        .accept(MediaType.APPLICATION_JSON));

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(member.getMemberId()))
                .andExpect(jsonPath("$.data.email").value(member.getEmail()))
                .andExpect(jsonPath("$.data.name").value(member.getName()))
                .andExpect(jsonPath("$.data.phone").value(member.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(member.getMemberStatus().getStatus()))
                .andDo(document(
                        "get-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면 상태 / 탈퇴 상태"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                ))
                ));
    }

    @Test
    public void deleteMemberTest() throws Exception {
        // given
        long memberId = 1L;
        doNothing().when(memberService).deleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(delete("/v11/members/{member-id}", memberId));

        // then
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        )
                ));
    }
}