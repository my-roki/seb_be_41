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
        tx.begin();  // Transaction을 시작하기 위해서 tx.begin() 메서드를 먼저 호출.
        Member member1 = new Member("roki@hello.com");
        Member member2 = new Member("toki@hello.com");

        em.persist(member1);  // member1 객체를 영속성 컨텍스트에 저장.
        em.persist(member2);  // member2 객체를 영속성 컨텍스트에 저장.

        tx.commit();  // 지연 SQL 저장소에 등록된 쿼리 실행.

        // em에서 find를 호출하면 1차적으로 영속성 컨탣스트에 저장되어있는 객체를 먼저 조회합니다.
        // 만약 영속성 컨텍스트 내에 객체가 존재하지 않는다면 쿼리를 통해 db에서 조회를 시도합니다.
        Member resul1 = em.find(Member.class, 1L);
        System.out.printf("id: %s%nemail: %s%n", resul1.getMemberId(), resul1.getEmail());

        Member result2 = em.find(Member.class, 2L);
        System.out.printf("id: %s%nemail: %s%n", result2.getMemberId(), result2.getEmail());

        Member result3 = em.find(Member.class, 3L);
        System.out.println(result3);
    }
}