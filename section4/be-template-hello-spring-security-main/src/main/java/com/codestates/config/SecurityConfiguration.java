package com.codestates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * 회원가입 폼을 만들기 위한 설계 과정
 * 1. PasswordEncoder(Spring Security에서 제공하는 패스워드 암호화 컴포넌트) Bean 등록
 * 2. MemberService Bean 등록을 위한 JavaConfiguration 구성
 * 3. InMemoryMemberService 클래스 구현
 */
@Configuration
public class SecurityConfiguration {
    // Note. Spring Security 설정을 진행합니다.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // Note. HttpSecurity를 통해 Http 요청에 대한 보안 설정을 구성합니다.
        httpSecurity.headers().frameOptions().sameOrigin() // 동일 출처로부터 들어오는 request만 페이지 렌더링을 허용
                .and()
                .csrf().disable()  // CSRF 공격에 대한 Spring Security 설정 비활성화
                .formLogin()  // 기본적인 인증방법 설정
                .loginPage("/auths/login-form")  // 핸들러 메서드에 요청을 전송하는 요청 URL
                .loginProcessingUrl("/process_login") // 메서드를 통해 로그인 인증 요청을 수행할 요청 URL
                .failureUrl("/auths/login-form?error")  // 메서드를 통해 로그인 인증에 실패할 경우 보낼 URL
                .and()  // Method chain
                .logout()
                .logoutUrl("/logout")  // 로그아웃 메서드 지정
                .logoutSuccessUrl("/")  // 성공시 던져질 URL
                .and()
                .exceptionHandling().accessDeniedPage("/auths/access-denied")  // 사용자가 URI에 접근할 수 없는 경우 예외처리
                .and()
                // ! 접근 권한 부여는 폭포수처럼 내려오기 때문에 항상 위치는 구체적인것 -> 일반적인것으로 작성할 것!
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/orders/**").hasRole(("ADMIN"))  // ADMIN Role을 부여받은 사용자만
                        .antMatchers("/members/my-page").hasRole("USER")  // USER Role를 부여받은 사람만
                        .antMatchers("/**").permitAll());  // 나머지 Role에 상관 없이

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
