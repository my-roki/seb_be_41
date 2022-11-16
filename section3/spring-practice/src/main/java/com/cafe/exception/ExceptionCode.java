package com.cafe.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_EXISTS(409, "Member exists"),
    MEMBER_NOT_FOUND(404, "Member not found"),
    COFFEE_CODE_EXISTS(409, "Coffee Code exists"),
    COFFEE_NOT_FOUND(404, "Coffee not found"),
    ORDER_NOT_FOUND(404, "Order not found"),
    CANNOT_CHANGE_ORDER(403, "Order can not change");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}