package com.springboot.admin.domain.model.network.response;

import com.springboot.admin.domain.enums.ItemStatus;
import com.springboot.admin.domain.model.network.request.ItemApiRequest;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemApiResponse {

    private Long id;

    private ItemStatus status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private Long partnerId;

}
