package com.imryuik.server.auth;

import com.imryuik.server.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.imryuik.server.config.JwtService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticateService service;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        registerRequest.setRole(Role.valueOf("USER"));
        return ResponseEntity.ok(service.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        AuthenticationResponse rep = service.authenticate(authenticationRequest);
        System.out.println(rep);
        return ResponseEntity.ok(rep);
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> hello(@RequestBody AuthenticateAction request) {
//        System.out.println("hey");
        try {
            boolean rep = jwtService.isTokenValid2(request.getToken());
            System.out.println(rep);
            return ResponseEntity.ok(rep);
        } catch (Exception error) {
            System.out.println("no");
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }
}
