package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderDetailRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = OrderDetail.builder()
                .status("WAITING")
                .arrivalDate(LocalDate.now().plusDays(2))
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(900000))
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                //.orderGroupId(1L)
                //.itemId(1L)
                .build();

        OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);

        assertNotNull(savedOrderDetail);
        //assertEquals(savedOrderDetail.getItemId(), 1L);
        // assertEquals(savedOrderDetail.getOrderGroupId(), 1L);
    }
}