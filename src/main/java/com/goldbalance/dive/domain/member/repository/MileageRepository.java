package com.goldbalance.dive.domain.member.repository;

import com.goldbalance.dive.domain.member.domain.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageRepository extends JpaRepository<Mileage, Long> {}
