package com.goldbalance.dive.domain.member.service;

import com.goldbalance.dive.domain.member.domain.Member;
import com.goldbalance.dive.domain.member.dto.request.MemberSignin;
import com.goldbalance.dive.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signin(MemberSignin request) {
        boolean isDuplicate = memberRepository.existsByNickname(request.nickname());
        if (isDuplicate) {
            throw new IllegalArgumentException();
        }

        Member member = Member.create(request.nickname());
        memberRepository.save(member);
    }
}
