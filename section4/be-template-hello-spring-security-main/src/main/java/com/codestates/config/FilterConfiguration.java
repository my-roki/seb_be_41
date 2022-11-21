package com.codestates.config;

import com.codestates.filter.FirstFilter;
import com.codestates.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot에서 Servlet Filter는 FilterRegistrationBean의 생성자로 Filter 인터페이스의 구현 객체를 넘겨주는 형태로 등록할 수 있습니다.
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterFilterRegistrationBean() {
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>(new FirstFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilterFilterRegistrationBean() {
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>(new SecondFilter());
        registrationBean.setOrder(2);
        return registrationBean;
    }
}