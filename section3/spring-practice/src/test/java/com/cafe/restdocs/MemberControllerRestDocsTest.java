package com.cafe.restdocs;

import com.cafe.member.controller.MemberController;
import com.cafe.member.dto.MemberDto;
import com.cafe.member.entity.Member;
import com.cafe.member.mapper.MemberMapper;
import com.cafe.member.service.MemberService;
import com.cafe.util.MemberControllerTestHelper;
import com.cafe.util.StubData;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpMethod;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.cafe.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.cafe.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO : 리팩토링 -> api문서화 공통부분 모듈화
@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureMockMvc(addFilters = false)
@AutoConfigureRestDocs
public class MemberControllerRestDocsTest implements MemberControllerTestHelper {
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
        MemberDto.Post post = (MemberDto.Post) StubData.MockMember.getRequestBody(HttpMethod.POST);
        String content = gson.toJson(post);
        MemberDto.Response response = StubData.MockMember.getSingleResponseBody();

        given(mapper.memberPostDtoToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());
        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(postRequestBuilder(getUrl(), content));

        // then
        // 유효성 검증에 사용된 애너테이션에 대한 정보를 추가
        ConstraintDescriptions postMemberConstraints = new ConstraintDescriptions(MemberDto.Post.class);
        List<String> emailDescriptions = postMemberConstraints.descriptionsForProperty("email");
        List<String> phoneDescriptions = postMemberConstraints.descriptionsForProperty("phone");

        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name.firstName").value(post.getName().getFirstName()))
                .andExpect(jsonPath("$.data.name.middleName").value(post.getName().getMiddleName()))
                .andExpect(jsonPath("$.data.name.lastName").value(post.getName().getLastName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andDo(document("post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일").attributes(key("constraints").value(emailDescriptions)),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("name").type(JsonFieldType.OBJECT).description("이름"),
                                        fieldWithPath("name.firstName").type(JsonFieldType.STRING).description("First name").optional(),
                                        fieldWithPath("name.middleName").type(JsonFieldType.STRING).description("Middle name").optional(),
                                        fieldWithPath("name.lastName").type(JsonFieldType.STRING).description("Last name").optional(),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호").attributes(key("constraints").value(phoneDescriptions))
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.OBJECT).description("이름"),
                                        fieldWithPath("data.name.firstName").type(JsonFieldType.STRING).description("First name"),
                                        fieldWithPath("data.name.middleName").type(JsonFieldType.STRING).description("Middle name"),
                                        fieldWithPath("data.name.lastName").type(JsonFieldType.STRING).description("Last name"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data.stampCount").type(JsonFieldType.NUMBER).description("스탬프 갯수"))
                        )
                ));
    }

    @Test
    public void getMembersTest() throws Exception {
        // given
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", "1");
        queryParams.add("size", "10");

        Page<Member> members = StubData.MockMember.getMemberPage();
        List<MemberDto.Response> response = StubData.MockMember.getMultiResponseBody();

        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);
        given(mapper.membersToListMemberResponseDto(Mockito.anyList())).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(getUrl(), queryParams));

        // then
        actions.andExpect(status().isOk())
                .andDo(document("get-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                List.of(
                                        parameterWithName("page").description("Page 번호"),
                                        parameterWithName("size").description("Page 크기")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data[].email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data[].name").type(JsonFieldType.OBJECT).description("이름"),
                                        fieldWithPath("data[].name.firstName").type(JsonFieldType.STRING).description("First name"),
                                        fieldWithPath("data[].name.middleName").type(JsonFieldType.STRING).description("Middle name"),
                                        fieldWithPath("data[].name.lastName").type(JsonFieldType.STRING).description("Last name"),
                                        fieldWithPath("data[].phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data[].memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data[].stampCount").type(JsonFieldType.NUMBER).description("스탬프 갯수"),
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
        MemberDto.Response response = StubData.MockMember.getSingleResponseBody();

        given(memberService.findMember(Mockito.anyLong())).willReturn(new Member());
        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(getUri(), memberId));

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(memberId))
                .andExpect(jsonPath("$.data.email").value(response.getEmail()))
                .andExpect(jsonPath("$.data.name.firstName").value(response.getName().getFirstName()))
                .andExpect(jsonPath("$.data.name.middleName").value(response.getName().getMiddleName()))
                .andExpect(jsonPath("$.data.name.lastName").value(response.getName().getLastName()))
                .andExpect(jsonPath("$.data.phone").value(response.getPhone()))
                .andDo(document("get-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(List.of(
                                parameterWithName("member-id").description("회원 식별자"))),
                        responseFields(List.of(
                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("data.name").type(JsonFieldType.OBJECT).description("이름"),
                                fieldWithPath("data.name.firstName").type(JsonFieldType.STRING).description("First name"),
                                fieldWithPath("data.name.middleName").type(JsonFieldType.STRING).description("Middle name"),
                                fieldWithPath("data.name.lastName").type(JsonFieldType.STRING).description("Last name"),
                                fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                fieldWithPath("data.stampCount").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                        ))
                ));
    }

    @Test
    public void patchMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Patch patch = (MemberDto.Patch) StubData.MockMember.getRequestBody(HttpMethod.PATCH);
        String content = gson.toJson(patch);
        MemberDto.Response responseDto = StubData.MockMember.getSingleResponseBody();

        given(mapper.memberPatchDtoToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());
        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());
        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(responseDto);

        // when
        ResultActions actions = mockMvc.perform(patchRequestBuilder(getUri(), memberId, content));

        // then
        // 유효성 검증에 사용된 애너테이션에 대한 정보를 추가
        ConstraintDescriptions postMemberConstraints = new ConstraintDescriptions(MemberDto.Post.class);
        List<String> phoneDescriptions = postMemberConstraints.descriptionsForProperty("phone");

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.name.firstName").value(patch.getName().getFirstName()))
                .andExpect(jsonPath("$.data.name.middleName").value(patch.getName().getMiddleName()))
                .andExpect(jsonPath("$.data.name.lastName").value(patch.getName().getLastName()))
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()))
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(List.of(
                                parameterWithName("member-id").description("회원 식별자"))),
                        requestFields(List.of(
                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),
                                fieldWithPath("name").type(JsonFieldType.OBJECT).description("이름").optional(),
                                fieldWithPath("name.firstName").type(JsonFieldType.STRING).description("First name").optional(),
                                fieldWithPath("name.middleName").type(JsonFieldType.STRING).description("Middle name").optional(),
                                fieldWithPath("name.lastName").type(JsonFieldType.STRING).description("Last name").optional(),
                                fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호").optional().attributes(key("constrains").value(phoneDescriptions)),
                                fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)").optional()
                        )),
                        responseFields(List.of(
                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("data.name").type(JsonFieldType.OBJECT).description("이름"),
                                fieldWithPath("data.name.firstName").type(JsonFieldType.STRING).description("First name"),
                                fieldWithPath("data.name.middleName").type(JsonFieldType.STRING).description("Middle name"),
                                fieldWithPath("data.name.lastName").type(JsonFieldType.STRING).description("Last name"),
                                fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                fieldWithPath("data.stampCount").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                        ))
                ));
    }

    @Test
    public void deleteMemberTest() throws Exception {
        // given
        long memberId = 1L;
        doNothing().when(memberService).deleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(deleteRequestBuilder(getUri(), memberId));

        // then
        actions.andExpect(status().isNoContent())
                .andDo(document("delete-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(List.of(parameterWithName("member-id").description("회원 식별자 ID")))
                ));
    }
}
