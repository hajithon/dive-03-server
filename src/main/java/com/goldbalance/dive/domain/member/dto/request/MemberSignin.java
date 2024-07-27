package com.goldbalance.dive.domain.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MemberSignin(@NotBlank String nickname) {}
