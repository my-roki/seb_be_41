package start.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

// 포인트컷을 공용으로 사용하기 위해 외부 클래스로 외부에 모아둘 수 있습니다.
// 외부에서 호출할 때는 포인트컷의 접근 제한자는 public 이어야 합니다.
public class Pointcuts {
    @Pointcut("execution(* start.aop.order..*(..))")
    public void allOrder() {
    }

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {
    }

    @Pointcut("allOrder() && allService()")
    public void orderAndService() {
    }
}
