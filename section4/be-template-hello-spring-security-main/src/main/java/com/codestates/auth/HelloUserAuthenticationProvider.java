package com.codestates.auth;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.Member;
import com.codestates.member.MemberService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

// Custom AuthenticationProvider
public class HelloUserAuthenticationProvider implements AuthenticationProvider {
    private final MemberService memberService;
    private final HelloAuthorityUtils authorityUtils;
    private final PasswordEncoder passwordEncoder;

    public HelloUserAuthenticationProvider(MemberService memberService, HelloAuthorityUtils authorityUtils, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.authorityUtils = authorityUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        // username이 존재하는가?
        String username = authentication.getName();
        Optional.ofNullable(username).orElseThrow(() -> new UsernameNotFoundException("Invalid User name or User Password"));

        Member member = memberService.findMember(username);

        // db에 저장된 패스워드가 일치하는가?
        String password = member.getPassword();
        verifyCredential(authenticationToken.getCredentials(), password);

        // 사용자 권한 생성
        List<GrantedAuthority> authorities = authorityUtils.createAuthorities(member.getRoles());

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    // Spring Security에게 Custom AuthenticationProvider를 사용한다는 것을 알려줍니다.
    @Override
    public boolean supports(Class<?> authentication) {

        // 리턴값이 true일경우 Spring Security는 직접 작성한 authenticate 메서드를 이용합니다.
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

    private void verifyCredential(Object credentials, String password) {
        if (!passwordEncoder.matches((String) credentials, password)) {
            throw new BadCredentialsException("Invalid User name or User Password");
        }
    }
}