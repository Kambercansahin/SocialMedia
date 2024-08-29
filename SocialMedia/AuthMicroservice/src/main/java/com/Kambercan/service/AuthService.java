package com.Kambercan.service;

import com.Kambercan.dto.request.CreateUserRequestDto;
import com.Kambercan.dto.request.LoginResponseDto;
import com.Kambercan.dto.request.RegisterRequestDto;
import com.Kambercan.entity.Auth;
import com.Kambercan.manager.UserProfileManager;
import com.Kambercan.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                        .authId(auth.getId())
                        .email(auth.getEmail())
                        .username(auth.getUserName())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
