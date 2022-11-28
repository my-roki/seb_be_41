package com.cafe.config;

import com.cafe.auth.filter.JwtAuthenticationFilter;
import com.cafe.auth.filter.JwtVerificationFilter;
import com.cafe.auth.handler.*;
import com.cafe.auth.jwt.JwtTokenizer;
import com.cafe.auth.utils.CustomAuthorityUtils;
import com.cafe.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;
    private final MemberService memberService;

    public SecurityConfig(JwtTokenizer jwtTokenizer, CustomAuthorityUtils authorityUtils, MemberService memberService) {
        this.jwtTokenizer = jwtTokenizer;
        this.authorityUtils = authorityUtils;
        this.memberService = memberService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // http security setting
        httpSecurity.headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .cors(withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigure())
                .and()
                .authorizeHttpRequests(a -> a
                        // member에 대한 접근 권한 설정
                        .antMatchers(HttpMethod.POST, "/*/members").permitAll()
                        .antMatchers(HttpMethod.GET, "/*/members").hasRole("ADMIN")
                        .antMatchers(HttpMethod.GET, "/*/members/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers(HttpMethod.PATCH, "/*/members/**").hasRole("USER")
                        .antMatchers(HttpMethod.DELETE, "/*/members/**").hasRole("USER")

                        // coffee에 대한 접근 권한 설정
                        .antMatchers(HttpMethod.POST, "/*/coffees").hasRole("ADMIN")
                        .antMatchers(HttpMethod.GET, "/*/coffees").permitAll()
                        .antMatchers(HttpMethod.GET, "/*/coffees/**").permitAll()
                        .antMatchers(HttpMethod.PATCH, "/*/coffees/**").hasRole("ADMIN")
                        .antMatchers(HttpMethod.DELETE, "/*/coffees/**").hasRole("ADMIN")

                        // order에 대한 접근권한 설정
                        .antMatchers(HttpMethod.POST, "/*/orders").hasRole("USER")
                        .antMatchers(HttpMethod.GET, "/*/orders").hasRole("ADMIN")
                        .antMatchers(HttpMethod.GET, "/*/orders/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers(HttpMethod.PATCH, "/*/orders/**").hasRole("USER, ADMIN")
                        .antMatchers(HttpMethod.DELETE, "/*/orders/**").hasRole("USER")
                )
                .oauth2Login(oauth2 ->
                        oauth2.successHandler(new OAuth2MemberSuccessHandler(jwtTokenizer, authorityUtils, memberService))
                );

        return httpSecurity.build();
    }

    // Cors configuration
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    private class CustomFilterConfigure extends AbstractHttpConfigurer<CustomFilterConfigure, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/v1/auth/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils);

            builder.addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, OAuth2LoginAuthenticationFilter.class);
        }
    }
}