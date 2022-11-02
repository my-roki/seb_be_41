package com.codestates.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "USERS")
@Table(name = "USERS")
public class Member {
    // @Id 애너테이션만 추가하면 기본적으로 기본키 직접 할당 전략이 적용됩니다.
    @Id
    private long memberId;
    private String email;

    public Member(long memberId, String  email) {
        this.memberId = memberId;
        this.email = email;
    }
}