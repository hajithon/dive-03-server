package com.goldbalance.dive.domain.member.repository;

import com.goldbalance.dive.domain.member.domain.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByNickname(String nickname);

    Optional<Member> findByNickname(String nickname);

    List<Member> findByOrderByMonthlyMileageDesc();

    List<Member> findByOrderByTotalMileageDesc();
}
