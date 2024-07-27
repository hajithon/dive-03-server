package com.goldbalance.dive.domain.member.dto;

import com.goldbalance.dive.domain.member.domain.Member;
import jakarta.validation.constraints.NotBlank;

public record MemberLogin(@NotBlank String nickname) {
    public static MemberLogin from(Member member) {
        return new MemberLogin(member.getNickname());
    }
}
