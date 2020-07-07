package com.springboot.admin.domain.repository;

import com.springboot.admin.AdminApplicationTests;
import com.springboot.admin.domain.model.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {
        AdminUser adminUser = AdminUser.builder()
                .account("AdminUser02")
                .password("AdminUser02")
                .status("REGISTERED")
                .role("PARTNER")
                .build();

        AdminUser savedAdminUser = adminUserRepository.save(adminUser);

        assertNotNull(savedAdminUser);
        assertEquals(savedAdminUser.getAccount(), "AdminUser02");
        assertEquals(savedAdminUser.getRole(), "PARTNER");
    }
}