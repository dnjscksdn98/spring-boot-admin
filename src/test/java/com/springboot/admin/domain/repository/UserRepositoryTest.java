package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test02";
        String password = "Test02";
        String status = "REGISTERED";
        String email = "Test02@example.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();

        User user = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .phoneNumber(phoneNumber)
                .registeredAt(registeredAt)
                .build();

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");

        if(user != null) {
            user.getOrderGroupList().stream()
                    .forEach(orderGroup -> {
                        System.out.println("----------------- 주문 묶음 -----------------");
                        System.out.println("총금액 : " + orderGroup.getTotalPrice());
                        System.out.println("총수량 : " + orderGroup.getTotalQuantity());
                        System.out.println("수령지 : " + orderGroup.getRevAddress());
                        System.out.println("수령인 : " + orderGroup.getRevName());

                        System.out.println("----------------- 주문 상세 -----------------");
                        orderGroup.getOrderDetailList().stream()
                                .forEach(orderDetail -> {
                                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                                    System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                                    System.out.println("주문 상태 : " + orderDetail.getStatus());
                                    System.out.println("도착 예정일 : " + orderDetail.getArrivalDate());
                                });
                    });
        }

        assertNotNull(user);
    }
}