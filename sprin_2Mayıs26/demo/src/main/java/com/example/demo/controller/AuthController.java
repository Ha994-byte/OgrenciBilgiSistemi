package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager
            authenticationManager;

    private final JwtService jwtService;


    //@GetMapping("/test")
    //public String test() {
      //  return "CALISTI";
    //}

    @PostMapping("/login")
    public LoginResponseDto login(
            @Valid @RequestBody LoginRequestDto dto
    ) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        String token =
                jwtService.generateToken(
                        dto.getUsername()
                );

        return new LoginResponseDto(token);
    }
}