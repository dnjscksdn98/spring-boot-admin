package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.OrderGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderGroupRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create() {
        OrderGroup orderGroup = OrderGroup.builder()
                .status("COMPLETE")
                .orderType("ALL")
                .revAddress("서울시 강남구")
                .revName("홍길동")
                .paymentType("CARD")
                .totalPrice(BigDecimal.valueOf(900000))
                .totalQuantity(1)
                .orderAt(LocalDateTime.now().minusDays(2))
                .arrivalDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                //.userId(1L)
                .build();

        OrderGroup savedOrderGroup = orderGroupRepository.save(orderGroup);

        assertNotNull(savedOrderGroup);
        assertEquals(savedOrderGroup.getRevName(), "홍길동");
        //assertEquals(savedOrderGroup.getUserId(), 1L);
    }
}