package com.supermarket.gateway.auth.repository;

import com.supermarket.gateway.auth.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(String memberId);
}
