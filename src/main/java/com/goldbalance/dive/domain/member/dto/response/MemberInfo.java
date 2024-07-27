package com.goldbalance.dive.domain.member.dto.response;

import com.goldbalance.dive.domain.member.domain.Member;
import java.util.List;

public record MemberInfo(
        String nickname,
        String tier,
        String mileage,
        String monthlyMileage,
        String overallMonthlyRank,
        String tierMonthlyRank,
        int totalMembers,
        int totalTierMembers) {
    public static MemberInfo of(
            Member member, List<Member> orderByMonthlyMileageDesc, List<Member> orderByTotalMileageDesc) {
        return new MemberInfo(
                member.getNickname(),
                member.getTier().getTierName(),
                member.getTotalMileage() + "P",
                member.getMonthlyMileage() + "P",
                orderByMonthlyMileageDesc.indexOf(member) + 1 + "등",
                orderByTotalMileageDesc.indexOf(member) + 1 + "등",
                orderByMonthlyMileageDesc.size(),
                orderByTotalMileageDesc.size());
    }
}
