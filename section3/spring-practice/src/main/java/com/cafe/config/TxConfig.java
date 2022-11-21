package com.cafe.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
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

@Configuration
public class TxConfig {
    private final TransactionManager transactionManager;

    public TxConfig(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Bean
    public TransactionInterceptor txAdvice() {
        // Note. 트랜잭션 적용을 위한 공통 메서드 등록 -> 메서드 이름으로 조회
        NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();

        // Note. find 메서드를 제외한 나머지 공통 메서드
        RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
        txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // Note. find 공통 메서드
        RuleBasedTransactionAttribute txFindAttribute = new RuleBasedTransactionAttribute();
        txFindAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txFindAttribute.setReadOnly(true);

        Map<String, TransactionAttribute> txMethod = new HashMap<>();
        txMethod.put("find*", txFindAttribute);
        txMethod.put("*", txAttribute);

        txAttributeSource.setNameMap(txMethod);

        return new TransactionInterceptor(transactionManager, txAttributeSource);
    }

    @Bean
    public Advisor txAdvisor() {
        // Note. Pointcut 설정
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.cafe.coffee.service.CoffeeService.*(..))");

        return new DefaultPointcutAdvisor(pointcut, txAdvice());

    }
}