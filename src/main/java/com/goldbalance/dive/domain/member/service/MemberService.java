package com.goldbalance.dive.domain.member.service;

import static com.goldbalance.dive.global.exception.ErrorCode.*;

import com.goldbalance.dive.domain.member.domain.Member;
import com.goldbalance.dive.domain.member.dto.MemberLogin;
import com.goldbalance.dive.domain.member.dto.request.MemberSignin;
import com.goldbalance.dive.domain.member.repository.MemberRepository;
import com.goldbalance.dive.global.exception.CustomException;
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
            throw new CustomException(MEMBER_NICKNAME_DUPLICATE);
        }

        Member member = Member.create(request.nickname());
        memberRepository.save(member);

        log.info("[MemberService] 멤버 회원가입 memberId = {}", member.getId());
    }

    public MemberLogin login(MemberLogin request) {
        Member member = memberRepository
                .findByNickname(request.nickname())
                .orElseThrow(() -> new CustomException(MEMBER_NOT_FOUND));

        log.info("[MemberService] 멤버 로그인 memberId = {}", member.getId());
        return MemberLogin.from(member);
    }
}
