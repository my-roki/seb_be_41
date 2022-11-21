package com.codestates.member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryMemberService implements MemberService {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public InMemoryMemberService(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Member createMember(Member member) {
        List<GrantedAuthority> authorities = createAuthorities(Member.MemberRole.ROLE_USER.name());
        String encryptedPassword = passwordEncoder.encode(member.getPassword());  // 비밀번호 암호화

        UserDetails userDetails = new User(member.getFullName(), encryptedPassword, authorities);
        userDetailsManager.createUser(userDetails);

        return member;
    }

    @Override
    public Member findMember(String member) {
        return null;
    }

    // ! Spring Security에서는 SimpleGrantedAuthority 를 사용해 Role 베이스 형태의 권한을 지정할 때 ‘Roll_’ + 권한명 형태로 지정해 주어야 합니다.
    private List<GrantedAuthority> createAuthorities(String... roles) {
        return Arrays.stream(roles)
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }
}
