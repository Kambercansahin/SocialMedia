package com.Kambercan.controller;

import com.Kambercan.dto.request.LoginResponseDto;
import com.Kambercan.dto.request.RegisterRequestDto;
import com.Kambercan.entity.Auth;
import com.Kambercan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.Kambercan.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)

public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto ){
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new RuntimeException("Wrong password");

        return ResponseEntity.ok(authService.register(dto));

    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDto dto){
        return ResponseEntity.ok(authService.login(dto));

    }
}
