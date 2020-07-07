package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryRepositoryTest extends AdminApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = Category.builder()
                .type(type)
                .title(title)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .build();

        Category savedCategory = categoryRepository.save(category);

        assertNotNull(savedCategory);
        assertEquals(savedCategory.getType(), type);
        assertEquals(savedCategory.getTitle(), title);
    }

    @Test
    public void read() {
        Optional<Category> category = categoryRepository.findByType("COMPUTER");

        category.ifPresent(c -> {
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }
}