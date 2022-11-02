package com.codestates.basic;

import com.codestates.entity.Member;
import com.codestates.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory enFactory) {
        this.em = enFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            example();
        };
    }

    private void example() {
        tx.begin();
        Member member = new Member("roki@hello.com", "roki", "010-1111-2222");
        em.persist(member);

        Order order = new Order();
        order.addMember(member);

        // member 객체에 order 객체를 추가해주지 않아도 테이블에는 정상적으로 업데이트 됩니다.
        // 하지만 find 메서드로 조회시 1차 캐시에 저장된 객테를 가져오는데 거기에는 order 정보가 들어있지 않습니다.
        member.addOrder(order);

        em.persist(order);
        tx.commit();

        Order findOrder = em.find(Order.class, 1L);
        System.out.printf("Find order: %s, %s, %s%n",
                findOrder.getMember().getMemberId(),
                findOrder.getMember().getEmail(),
                findOrder.getMember().getName());

        Member findMember = em.find(Member.class, 1L);
        findMember.getOrderList().stream()
                .forEach(memberOrder ->
                        System.out.printf("Member's order: %s, %s%n",
                                memberOrder.getOrderId(), memberOrder.getOrderStatus()
                        ));
    }
}