package start.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
// 포인트컷 표현식을 사용하고 메서드 이름과 파라미터를 합쳐서 포인트컷 시그니처(signature)라고 합니다.
public class Aspect2 {
    @Pointcut("execution(* start.aop.order..*(..))")
    private void allOrder() {
    }

    @Around("allOrder()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

}