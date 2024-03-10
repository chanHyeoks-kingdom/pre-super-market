package com.supermarket.gateway.auth.controller;

import com.supermarket.gateway.auth.dto.MemberRegistrationRequestDTO;
import com.supermarket.gateway.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping()
    public ResponseEntity<String> registerUser(@Valid @RequestBody MemberRegistrationRequestDTO memberRegistrationRequestDTO) {
        authenticationService.registerMember(memberRegistrationRequestDTO);

        return ResponseEntity.ok("회원가입 성공");
    }
}
