package com.codestates.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDER_COFFEE")
public class CoffeeRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderCoffeeId;

    @ManyToOne
    @JoinColumn(name = "COFFEE_ID")
    private Coffee coffee;

    public void addCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private long quantity;

    public CoffeeRef(long quantity) {
        this.quantity = quantity;
    }

    public void addOrder(Order order) {
        this.order = order;
    }
}