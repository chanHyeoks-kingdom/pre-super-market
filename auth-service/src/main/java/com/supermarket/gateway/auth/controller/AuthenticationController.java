package com.supermarket.gateway.auth.controller;

import com.supermarket.gateway.auth.dto.MemberRegistrationDTO;
import com.supermarket.gateway.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody MemberRegistrationDTO memberRegistrationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().body("회원가입 데이터가 유효하지 않습니다. ID는 존재해야 하며, 비밀번호는 최소 8자리 이상이어야 합니다.\n" + bindingResult.getAllErrors()); }
        authenticationService.registerMember(memberRegistrationDTO);

        return ResponseEntity.ok("회원가입 성공");
    }
}
