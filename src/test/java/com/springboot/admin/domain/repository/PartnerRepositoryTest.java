package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PartnerRepositoryTest extends AdminApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-1111";
        String partnerNumber = "010-1111-1111";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = Partner.builder()
                .name(name)
                .status(status)
                .address(address)
                .callCenter(callCenter)
                .partnerNumber(partnerNumber)
                .businessNumber(businessNumber)
                .ceoName(ceoName)
                .registeredAt(registeredAt)
                .createdAt(createdAt)
                .createdBy(createdBy)
                //.categoryId(categoryId)
                .build();

        Partner savedPartner = partnerRepository.save(partner);

        assertNotNull(savedPartner);
        assertEquals(savedPartner.getName(), name);
    }
}