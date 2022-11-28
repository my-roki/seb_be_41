package com.cafe.util;

import com.cafe.member.dto.MemberDto;
import com.cafe.member.entity.Member;
import com.cafe.member.entity.Username;
import com.cafe.stamp.Stamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubData {
    private static final Map<HttpMethod, Object> stubRequestBody;

    static {
        stubRequestBody = new HashMap<>();
        stubRequestBody.put(HttpMethod.POST, new MemberDto.Post("admin@hello.com", "1111", new Username("firstName", "middleName", "lastName"), "010-1234-1234"));
        stubRequestBody.put(HttpMethod.PATCH, new MemberDto.Patch(1L, new Username("firstName", "middleName", "lastName"), "010-1234-1234", Member.MemberStatus.MEMBER_ACTIVE));
    }

    public static class MockMember {
        public static Object getRequestBody(HttpMethod method) {
            return stubRequestBody.get(method);
        }

        public static Page<Member> getMemberPage() {
            Member admin = new Member("admin@hello.com", new Username("firstName", "middleName", "lastName"), "010-1111-1111");
            admin.setStamp(new Stamp());

            Member user = new Member("user@hello.com", new Username("firstName", "middleName", "lastName"), "010-2222-2222");
            user.setStamp(new Stamp());

            return new PageImpl<>(List.of(admin, user), PageRequest.of(0, 10, Sort.by("memberId").descending()), 2);
        }

        public static MemberDto.Response getSingleResponseBody() {
            return new MemberDto.Response(1L, "admin@hello.com", new Username("firstName", "middleName", "lastName"), "010-1234-1234", Member.MemberStatus.MEMBER_ACTIVE.getStatus(), new Stamp().getStampCount());
        }

        public static List<MemberDto.Response> getMultiResponseBody() {
            return List.of(
                    new MemberDto.Response(1L, "admin@hello.com", new Username("firstName", "middleName", "lastName"), "010-1234-1234", Member.MemberStatus.MEMBER_ACTIVE.getStatus(), new Stamp().getStampCount()),
                    new MemberDto.Response(2L, "user@hello.com", new Username("firstName", "middleName", "lastName"), "010-9876-9876", Member.MemberStatus.MEMBER_ACTIVE.getStatus(), new Stamp().getStampCount())
            );
        }
    }
}