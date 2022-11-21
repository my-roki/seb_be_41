package com.codestates.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class SecondFilter implements Filter {
    // 초기화 작업
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("@@@ SecondFilter 생성됨!!!!");
    }

    // Filter가 실질적으로 처리되는 로직 구현
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("******** SecondFilter 시작 ********");  // chain.doFilter(request, response)가 호출되기 전에 할 수 있는 전처리 작업에 대한 코드를 구현
        chain.doFilter(request, response);
        log.info("******** SecondFilter 종료 ********");  // chain.doFilter(request, response)가 호출된 이 후에 할 수 있는 후처리 작업에 대한 코드를 구현
    }

    // Filter가 사용한 자원을 반납하는 처리
    @Override
    public void destroy() {
        log.info("@@@ SecondFilter 소멸됨!!!!");
        Filter.super.destroy();

    }
}