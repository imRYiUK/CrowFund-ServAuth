package com.imryuik.server.auth;

import com.imryuik.server.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.imryuik.server.config.JwtService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticateService service;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        registerRequest.setRole(Role.valueOf("USER"));
        return ResponseEntity.ok(service.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(service.authenticate(authenticationRequest));
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> hello(@RequestBody AuthenticateAction request) {
        return ResponseEntity.ok(jwtService.isTokenValid2(request.getToken()));
    }
}
