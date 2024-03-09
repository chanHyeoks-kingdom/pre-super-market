package com.supermarket.gateway.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberRegistrationDTO {
    @NotBlank(message = "회원 ID는 필수입니다.")
    private final String memberId;
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private final String password;
}
