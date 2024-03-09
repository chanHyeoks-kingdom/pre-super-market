package com.supermarket.gateway.auth.service;

import com.supermarket.gateway.auth.dto.MemberRegistrationDTO;
import com.supermarket.gateway.auth.entity.Member;
import com.supermarket.gateway.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public Member registerMember(final MemberRegistrationDTO memberRegistrationDTO) {
        Optional<Member> existingMember = memberRepository.findByMemberId(memberRegistrationDTO.getMemberId());
        if (existingMember.isPresent()) { throw new IllegalStateException("이미 존재하는 회원 ID입니다."); }

        Member newMember = Member.createWithEncodedPassword(memberRegistrationDTO.getMemberId(), passwordEncoder.encode(memberRegistrationDTO.getPassword()));
        return memberRepository.save(newMember);
    }
}
