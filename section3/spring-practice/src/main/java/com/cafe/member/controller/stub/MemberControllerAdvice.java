package com.cafe.member.controller.stub;

import com.cafe.member.dto.MemberDto;
import com.cafe.member.entity.Member;
import com.cafe.member.entity.Username;
import com.cafe.response.SingleResponseDto;
import com.cafe.stamp.Stamp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Note 2번 방법(AOP를 이용한 고오급 기능) :
 * 모든 stub data를 controller에 직접 작성하지 않고, Advice를 활용해 컨트롤러 호출 시점에 맞춰 가로채서 실행해줍니다.
 * 컨트롤러와 별개로 독립적으로 작동하기 때문에 컨트롤러 코드 작성에 문제를 주지 않습니다.
 */

//@Aspect
@Component
public class MemberControllerAdvice {
    @Pointcut("execution(* com.cafe.member.controller.MemberController.*(..))")
    public void returnSingleResponseDto() {}

    @Around(value = "returnSingleResponseDto()")
    public ResponseEntity aroundPostMember(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.print("##### Apply Around Join Point : ");
        System.out.println(joinPoint.getSignature());
        MemberDto.Response response = new MemberDto.Response(
                1L,
                "roki@hello.com",
                new Username("roki", "middle", "yoon"),
                "010-1111-1111",
                Member.MemberStatus.MEMBER_ACTIVE.getStatus(),
                new Stamp().getStampCount());

        HttpStatus status = HttpStatus.OK;
        String methodName = joinPoint.getSignature().getName();
        if (methodName.equals("postMember")) {
            status = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(new SingleResponseDto<>(response), status);
    }
}