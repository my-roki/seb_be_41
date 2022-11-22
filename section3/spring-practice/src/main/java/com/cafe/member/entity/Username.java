package com.cafe.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Username {
    private String firstName = "first";
    private String middleName = "middle";
    private String lastName = "last";
}