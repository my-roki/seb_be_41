package com.codestates.coffee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CoffeeId;

    @Column(nullable = false, length = 100)
    private String korName;

    @Column(nullable = false, length = 100)
    private String engName;

    @Column(nullable = false, length = 5)
    private int price;

    @Column(nullable = false, updatable = true, length = 3)
    private String coffeeCode;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

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
