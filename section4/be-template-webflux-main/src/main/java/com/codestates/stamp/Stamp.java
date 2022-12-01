package com.codestates.stamp;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Table
public class Stamp {
    @Id
    private long stampId;
    private int stampCount;

    // Note. R2DBC는 별도의 연관관계 매핑을 지원하지 않습니다. 연관관계 매핑이 적용되는 순간 내부적으로 Blocking 요소가 포함될 수 있기 때문입니다.
    private long memberId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt;

    public Stamp(long memberId) {
        this.memberId = memberId;
    }
}