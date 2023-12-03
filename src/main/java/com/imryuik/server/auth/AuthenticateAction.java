package com.imryuik.server.auth;

import com.imryuik.server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AuthenticateAction {
    private User user;
    private String token;
}
