package com.seonjuleee.accountbook.entity;

import com.seonjuleee.accountbook.model.Status;
import lombok.*;

import javax.persistence.*;

@Getter
//@Setter // 책의 예시에는 포함되어 있지만 가급적 setter를 사용하지 않는 것이 좋으므로 생략함
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "status", "amount", "description"})
public class Item extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING) // enum 값 문자 그대로 저장
    private Status status; // 지출/수입 상태
    private long amount;
    private String description;
}
