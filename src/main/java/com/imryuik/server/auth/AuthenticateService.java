package com.imryuik.server.auth;

import com.imryuik.server.config.JwtService;
import com.imryuik.server.entity.User;
import com.imryuik.server.mapper.MapStructMapper;
import com.imryuik.server.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final MapStructMapper mapper;

    public AuthenticateService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, MapStructMapper mapper) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.mapper = mapper;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phone_number(request.getPhone_number())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userDTO(mapper.userToUserDTO(user))
                .build();
    }
}
