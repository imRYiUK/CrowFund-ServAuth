package com.imryuik.server.auth;


import com.imryuik.server.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone_number;
    private Role role;
}
