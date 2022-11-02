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
        Member createMember = new Member("roki@hello.com");
        em.persist(createMember);  // member1 객체를 영속성 컨텍스트에 저장.
        tx.commit();  // 지연 SQL 저장소에 등록된 INSERT 쿼리 실행.

        tx.begin();
        Member updateMember = em.find(Member.class, 1L);  // 테이블에 저장된 member 객체를 영속성 컨텍스트의 1차 캐시에서 조회
        updateMember.setEmail("toki@hello.com");  // setter 메서드로 이메일 정보를 변경
        tx.commit();  // 지연 SQL 저장소에 등록된 UPDATE 쿼리가 실행

        tx.begin();
        Member deleteMember = em.find(Member.class, 1L);  // 테이블에 저장된 Member 클래스의 객체를 영속성 컨텍스트의 1차 캐시에서 조회
        em.remove(deleteMember);  //  영속성 컨텍스트의 1차 캐시에 있는 엔티티를 제거를 요청
        tx.commit();  // 영속성 컨텍스트의 1차 캐시에 있는 엔티티를 제거하고, 쓰기 지연 SQL 저장소에 등록된 DELETE 쿼리가 실행
    }
}