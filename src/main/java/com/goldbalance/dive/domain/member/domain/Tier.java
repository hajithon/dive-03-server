package com.goldbalance.dive.domain.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Tier {
	BRONZE("브론즈"),
	SILVER("실버"),
	GOLD("골드"),
	DIAMOND("다이아"),
	MASTER("마스터");

	private final String tierName;
}
