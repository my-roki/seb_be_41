package com.codestates.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Stamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stampId;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private int stampCount = 0;

    public void setStampCount(int stampCount) {
        this.stampCount = stampCount;
    }

    public void addMember(Member member) {
        this.member = member;
    }
}