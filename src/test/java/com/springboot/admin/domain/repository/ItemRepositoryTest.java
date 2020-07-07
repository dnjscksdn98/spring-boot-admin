package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ItemRepositoryTest extends AdminApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = Item.builder()
                .status("UNREGISTERED")
                .name("삼성 노트북")
                .title("삼성 노트북 A100")
                .content("2020년형 노트북입니다.")
                .price(new BigDecimal("900000"))
                .brandName("삼성")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Partner01")
                //.partnerId(1L)
                .build();

        Item savedItem = itemRepository.save(item);

        assertNotNull(savedItem);
        assertEquals(item.getName(), "삼성 노트북");
    }
}