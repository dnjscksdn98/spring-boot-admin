package com.springboot.admin.domain.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * API Response Header common data
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header<T> {

    /**
     * API 통신 시간
     *
     * API 응답 코드
     *
     * API 부가 설명
     *
     * Response Body data
     */

    private LocalDateTime transactionTime;

    private String resultCode;

    private String description;

    private T data;

    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
