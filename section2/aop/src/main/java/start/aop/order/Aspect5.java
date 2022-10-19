package start.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

// @Aspect 적용 단위로 @Order 애너테이션을 적용하지만 어드바이스 단위가 아닌 클래스 단위로 적용할 수 있습니다.
// 하나의 애스펙트 안에 여러 어드바이스가 있으면 순서를 보장 받을 수 없기 때문에 별도의 클래스로 애스펙트를 분리해야 합니다.
@Slf4j
@Aspect
public class Aspect5 {

    @Aspect
    @Order(2)
    public static class LogAspect {
        @Around("start.aop.order.aop.Pointcuts.allOrder()")
        public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("log -> {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(1)
    public static class TxAspect {
        @Around("start.aop.order.aop.Pointcuts.orderAndService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

            try {
                log.info("트랜잭션 시작 -> {}", joinPoint.getSignature());
                Object result = joinPoint.proceed();
                log.info("트랜잭션 커밋 -> {}", joinPoint.getSignature());
                return result;
            } catch (Exception e) {
                log.info("트랜잭션 롤백 -> {}", joinPoint.getSignature());
                throw e;
            } finally {
                log.info("리소스 릴리즈 -> {}", joinPoint.getSignature());
            }
        }
    }
}