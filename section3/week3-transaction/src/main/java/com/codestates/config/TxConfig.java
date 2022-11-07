package com.codestates.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.HashMap;
import java.util.Map;

// AOP 방식으로 트랜잭션을 적용하기 위한 Configuration 클래스 정의
@Configuration
public class TxConfig {
    private final TransactionManager transactionManager;

    public TxConfig(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Bean
    public TransactionInterceptor txAdvice() {
        NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();

        // 공통 트랜잭션 어트리뷰트
        RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
        txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // Read-Only 트랜잭션 어트리뷰트
        RuleBasedTransactionAttribute txFindAttribute = new RuleBasedTransactionAttribute();
        txFindAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txFindAttribute.setReadOnly(true);

        // Map의 key를 메서드 이름 패턴으로 지정해서 각각의 트랜잭션 애트리뷰트를 추가
        Map<String, TransactionAttribute> txMethod = new HashMap<>();
        txMethod.put("find*", txFindAttribute);
        txMethod.put("*", txAttribute);

        txAttributeSource.setNameMap(txMethod);

        return new TransactionInterceptor(transactionManager, txAttributeSource);
    }


    @Bean
    public Advisor txAdvisor() {
        // 포인트 컷 표현식으로 CoffeeService 클래스를 타겟 클래스로 지정
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.codestates.coffee.service." +
                "CoffeeService.*(..))");

        // 분산 트랜잭션 적용을 위해 AOP 설정에 MemberService, BackupMemberService 추가
        pointcut.setExpression("execution(* com.codestates.member.service." +
                "MemberService.*(..))");
        pointcut.setExpression("execution(* com.codestates.backup.service." +
                "BackupMemberService.*(..))");

        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}