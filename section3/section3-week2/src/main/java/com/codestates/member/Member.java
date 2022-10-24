package com.codestates.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Member class 는 API 계층에서 전달 받은 요청 데이터를 기반으로 서비스 계층에서 비즈니스 로직을 처리하기 위해 필요한 데이터를 전달 받고,
비즈니스 로직을 처리한 후에는 결과 값을 다시 API 계층으로 리턴해주는 역할을 합니다.
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}