package com.codestates.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "USERS")
@Table(name = "USERS")
public class Member {
    // @GeneratedValue 애너테이션의 strategy 애트리뷰트의 값을 지정
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memberId;
    private String email;

    public Member(String email) {
        this.email = email;
    }
}