package com.codestates.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    // EnumType.ORDINAL : enum의 순서를 나타내는 숫자를 테이블에 저장합니다.
    // EnumType.STRING : enum의 이름을 테이블에 저장합니다.
    // 테이블에 이미 저장되어 있는 enum 순서 번호와 enum에 정의되어 있는 순서가 일치하지 않게 되는 문제가 발생하지 않도록
    // EnumType.STRING 을 사용하는 것이 좋습니다..
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    // @ManyToOne 어노테이션을 통해 다대일 관계를 명시합니다.
    // @JoinColumn 어노테이션으로 ORDERS 테이블에서 외래키에 해당하는 컬럼명을 적어줍니다.
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public void addMember(Member member) {
        this.member = member;
    }


    public enum OrderStatus {
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");

        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        OrderStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }
}