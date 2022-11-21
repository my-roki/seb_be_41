package com.cafe.coffee.entity;

import com.cafe.order.entity.OrderCoffee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffeeId;

    @Column(nullable = false, length = 100)
    private String korName;

    @Column(nullable = false, length = 100)
    private String engName;

    @Column(nullable = false, length = 5)
    private Integer price;

    @Column(nullable = false, length = 3, unique = true)
    private String coffeeCode;

    @Column(length = 50)
    private String coffeeImageName;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    @OneToMany(mappedBy = "coffee")
    private List<OrderCoffee> orderCoffees = new ArrayList<>();

    public void addOrderCoffee(OrderCoffee orderCoffee) {
        this.orderCoffees.add(orderCoffee);
        if (orderCoffee.getCoffee() != this) {
            orderCoffee.setCoffee(this);
        }
    }

    public enum CoffeeStatus {
        COFFEE_FOR_SALE("판매중"),
        COFFEE_SOLD_OUT("판매중지");

        @Getter
        private String status;

        CoffeeStatus(String status) {
            this.status = status;
        }
    }
}