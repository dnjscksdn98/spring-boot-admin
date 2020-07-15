package com.springboot.admin.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {

    REGISTERED(0, "등록", "상품 등록상태"),
    UNREGISTERED(1, "해지", "상품 해지상태"),
    WAITING(2, "검수(대기)", "상품 검수상태");

    private final Integer id;
    private final String title;
    private final String description;
}
