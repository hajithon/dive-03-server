package com.goldbalance.dive.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import com.goldbalance.dive.domain.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
