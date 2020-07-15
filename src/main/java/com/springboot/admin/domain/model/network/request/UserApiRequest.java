package com.springboot.admin.domain.model.network.request;

import com.springboot.admin.domain.enums.UserStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserApiRequest {
    
    private Long id;
    
    private String account;
    
    private String password;
    
    private UserStatus status;
    
    private String email;
    
    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}
