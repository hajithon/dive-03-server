package com.goldbalance.dive.domain.member.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mileage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mileage_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	private long amount;

	@Enumerated(EnumType.STRING)
	private MileageType type;

	private LocalDateTime createdAt;


	@Builder(access = AccessLevel.PRIVATE)
	private Mileage(Member member, long amount, MileageType type) {
		this.member = member;
		this.amount = amount;
		this.type = type;
		this.createdAt = LocalDateTime.now();
	}

	public static Mileage create(Member member, long amount, MileageType type) {
		return Mileage.builder()
			.member(member)
			.amount(amount)
			.type(type)
			.build();
	}
}
