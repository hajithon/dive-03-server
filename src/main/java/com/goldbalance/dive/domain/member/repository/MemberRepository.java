package com.goldbalance.dive.domain.member.repository;

import com.goldbalance.dive.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {}
