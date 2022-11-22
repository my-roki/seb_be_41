package com.cafe.util;

public interface MemberControllerTestHelper extends ControllerTestHelper {
    String MEMBER_URL = "/v1/members";
    String RESOURCE_URI = "/{member-id}";

    default String getUrl() {
        return MEMBER_URL;
    }

    default  String getUri() {
        return MEMBER_URL+RESOURCE_URI;
    }
}