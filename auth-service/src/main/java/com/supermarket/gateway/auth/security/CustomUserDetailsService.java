package com.supermarket.gateway.auth.security;

import com.supermarket.gateway.auth.entity.Member;
import com.supermarket.gateway.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(final String memberId) throws UsernameNotFoundException {
        Member findMember = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new UsernameNotFoundException("member not found with memberId: " + memberId));

        return new User(String.valueOf(findMember.getMemberId()), findMember.getPassword(), new ArrayList<>());
    }
}