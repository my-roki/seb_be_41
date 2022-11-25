package com.codestates.hello_oauth2.home;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloHomeController {
    private final OAuth2AuthorizedClientService auth2AuthorizedClientService;

    public HelloHomeController(OAuth2AuthorizedClientService auth2AuthorizedClientService) {
        this.auth2AuthorizedClientService = auth2AuthorizedClientService;
    }


    @GetMapping("/hello-oauth2")
    public String home(Authentication authentication,
                       @AuthenticationPrincipal OAuth2User oAuth2User,
                       @RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient2) {
        // 인증된 Authentication 정보 확인
        // 1. SecurityContext를 이용하는 방법
        OAuth2User principal2 = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal2.getAttributes().get("email"));

        // 2. Authentication 객체를 핸들러 메서드 파라미터로 전달 받는 방법
        OAuth2User principal1 = (OAuth2User) authentication.getPrincipal();
        System.out.println(principal1);
        System.out.println("User's email in Google: " + principal1.getAttributes().get("email"));

        // 3. OAuth2User를 파라미터로 전달 받는 방법
        System.out.println("User's email in Google: " + oAuth2User.getAttributes().get("email"));


        // Authorization Server로부터 전달 받은 Access Token 확인
        // 1. OAuth2AuthorizedClientService를 DI 받는 방법
        OAuth2AuthorizedClient authorizedClient1 = auth2AuthorizedClientService.loadAuthorizedClient("google", authentication.getName());
        OAuth2AccessToken accessToken1 = authorizedClient1.getAccessToken();

        System.out.println("Access Token Value: " + accessToken1.getTokenValue());
        System.out.println("Access Token Type: " + accessToken1.getTokenType());
        System.out.println("Access Token Scope: " + accessToken1.getScopes());
        System.out.println("Access Token Issued At: " + accessToken1.getIssuedAt());
        System.out.println("Access Token Expires At: " + accessToken1.getExpiresAt());

        // 2. OAuth2AuthorizedClient를 핸들러 메서드의 파라미터로 전달 받는 방법
        OAuth2AccessToken accessToken2 = authorizedClient2.getAccessToken();
        System.out.println("Access Token Value: " + accessToken2.getTokenValue());
        System.out.println("Access Token Type: " + accessToken2.getTokenType());
        System.out.println("Access Token Scope: " + accessToken2.getScopes());
        System.out.println("Access Token Issued At: " + accessToken2.getIssuedAt());
        System.out.println("Access Token Expires At: " + accessToken2.getExpiresAt());

        return "hello-oauth2";
    }
}