package com.cafe.member.dto;

import com.cafe.member.entity.Member;
import com.cafe.member.entity.Username;
import com.cafe.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @Email(message = " 올바른 형식의 이메일주소여야 합니다.")
        @NotBlank(message = "이메일은 공백이 아니어야 합니다.")
        private String email;

        private Username name;

        @Pattern(regexp = "^01\\d-\\d{3,4}-\\d{4}",
                message = "핸드폰 번호는 01x로 시작하는 11자리 숫자로 이루어져야합니다. 구분자는 '-'으로 구분됩니다.")
        private String phone;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long memberId;

        private Username name;

        @NotSpace(message = "핸드폰 번호는 공백이 아니어야 합니다.")
        @Pattern(regexp = "^01\\d-\\d{3,4}-\\d{4}",
                message = "핸드폰 번호는 01x로 시작하는 11자리 숫자로 이루어져야합니다. 구분자는 '-'으로 구분됩니다.")
        private String phone;

        private Member.MemberStatus memberStatus;

        public void setMemberId(long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long memberId;
        private String email;
        private Username name;
        private String phone;
        private String memberStatus;
        private Integer stampCount;
    }
}