package com.codestates.basic;

import com.codestates.entity.Member;
import com.codestates.entity.Stamp;
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
        // @OneToOne test
        tx.begin();
        // Member 엔티티 생성
        // Stamp 엔티티 생성
        Member member1 = new Member("roki@hello.com", "roki", "010-1111-2222");
        Member member2 = new Member("toki@hello.com", "toki", "010-9999-8888");
        Stamp stamp1 = new Stamp();
        Stamp stamp2 = new Stamp();

        stamp1.setStampCount(10);
        stamp2.setStampCount(5);
        stamp1.addMember(member1);
        stamp2.addMember(member2);

        member1.addStamp(stamp1);
        member2.addStamp(stamp2);

        em.persist(stamp1);
        em.persist(member1);
        em.persist(stamp2);
        em.persist(member2);
        tx.commit();

        System.out.println("<<< Member >>>");
        System.out.printf(" member email: %s%n", member1.getEmail());
        System.out.printf(" member stamp: %d%n", member1.getStamp().getStampCount());
        System.out.printf(" member email: %s%n", member2.getEmail());
        System.out.printf(" member stamp: %d%n", member2.getStamp().getStampCount());
    }

}