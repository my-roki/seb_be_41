package com.codestates.basic;

import com.codestates.entity.Coffee;
import com.codestates.entity.CoffeeRef;
import com.codestates.entity.Member;
import com.codestates.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.Map;

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
        // @ManyToMany test
        tx.begin();

        // Member, Coffee 엔티티 생성
        Member member = new Member("roki@hello.com", "roki", "010-1111-2222");
        Coffee americano = new Coffee("아메리카노", "Americano", 3500, "AME");
        Coffee caffeLatte = new Coffee("카페라테", "Caffe Latte", 4000, "CFL");
        em.persist(member);
        em.persist(americano);
        em.persist(caffeLatte);

        // Order, CoffeRef(커피 주문) 생성
        CoffeeRef coffeeRef1 = new CoffeeRef(2);  // 생성자 매개변수는 quantity
        CoffeeRef coffeeRef2 = new CoffeeRef(1);
        coffeeRef1.addCoffee(americano);
        coffeeRef2.addCoffee(caffeLatte);
        em.persist(coffeeRef1);
        em.persist(coffeeRef2);

        Order order = new Order();
        order.addMember(member);
        order.addCoffeeRef(coffeeRef1);
        order.addCoffeeRef(coffeeRef2);

        coffeeRef1.addOrder(order);
        coffeeRef2.addOrder(order);
        member.addOrder(order);
        em.persist(order);

        tx.commit();

        // 객체끼리 잘 매핑 됐는지 확인
        // Order에 커피 정보가 잘 들어갔는지 확인
        Order findOrder = em.find(Order.class, 1L);
        System.out.println("<<< Order >>>");
        System.out.printf(" member id: %s%n member email: %s%n member name: %s%n",
                findOrder.getMember().getMemberId(),
                findOrder.getMember().getEmail(),
                findOrder.getMember().getName());
        findOrder.getCoffeeRefList().stream().
                forEach(coffeeRef -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("korName", coffeeRef.getCoffee().getKorName());
                    map.put("engName", coffeeRef.getCoffee().getEngName());
                    map.put("price", coffeeRef.getCoffee().getPrice());
                    map.put("coffeeCode", coffeeRef.getCoffee().getCoffeeCode());
                    System.out.printf(" coffee: %s, quantity: %d%n", map, coffeeRef.getQuantity());
                });

        System.out.println("-".repeat(88));

        // Member에 Order가 잘 들어갔는지 확인
        Member findMember = em.find(Member.class, 1L);
        System.out.println("<<< Member >>>");
        System.out.printf(" member email: %s%n", findMember.getEmail());
        findMember.getOrderList().stream()
                .forEach(memberOrder -> {
                    System.out.printf(" order id: %d%n order status: %s%n",
                            memberOrder.getOrderId(),
                            memberOrder.getOrderStatus());
                    memberOrder.getCoffeeRefList().stream().
                            forEach(coffeeRef -> {
                                Map<String, Object> map = new HashMap<>();
                                map.put("korName", coffeeRef.getCoffee().getKorName());
                                map.put("engName", coffeeRef.getCoffee().getEngName());
                                map.put("price", coffeeRef.getCoffee().getPrice());
                                map.put("coffeeCode", coffeeRef.getCoffee().getCoffeeCode());
                                System.out.printf(" coffee: %s, quantity: %d%n", map, coffeeRef.getQuantity());
                            });
                });
    }
}