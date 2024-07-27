package com.goldbalance.dive.domain.member.service;

import com.goldbalance.dive.domain.member.domain.Member;
import com.goldbalance.dive.domain.member.dto.request.MemberSignin;
import com.goldbalance.dive.domain.member.repository.MemberRepository;
import com.goldbalance.dive.global.exception.CustomException;
import com.goldbalance.dive.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signin(MemberSignin request) {
        boolean isDuplicate = memberRepository.existsByNickname(request.nickname());
        if (isDuplicate) {
            throw new CustomException(ErrorCode.MEMBER_NICKNAME_DUPLICATE);
        }

        Member member = Member.create(request.nickname());
        memberRepository.save(member);

        log.info("[MemberService] 멤버 회원가입 memberId = {}", member.getId());
    }
}
