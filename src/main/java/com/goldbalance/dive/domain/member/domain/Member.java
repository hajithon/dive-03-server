package com.goldbalance.dive.domain.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(unique = true)
	private String nickname;

	@Enumerated(EnumType.STRING)
	private Tier tier;

	private long totalMileage;

	private long monthlyMileage;

	@Builder(access = AccessLevel.PRIVATE)
	private Member(String nickname, Tier tier, long totalMileage, long monthlyMileage) {
		this.nickname = nickname;
		this.tier = tier;
		this.totalMileage = totalMileage;
		this.monthlyMileage = monthlyMileage;
	}

	public static Member create(String nickname) {
		return Member.builder()
				.nickname(nickname)
				.tier(Tier.BRONZE)
				.totalMileage(0)
				.monthlyMileage(0)
				.build();
	}
}
