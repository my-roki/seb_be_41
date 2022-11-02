package com.codestates.basic;

import com.codestates.entity.Member;
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
        em.persist(new Member(1L, "roki@hello.com"));
        tx.commit();

        Member member = em.find(Member.class, 1L);  // 기본키를 직접 할당해서 엔티티를 저장

        System.out.printf("id: %s%nemail: %s%n", member.getMemberId(), member.getEmail());
    }
}