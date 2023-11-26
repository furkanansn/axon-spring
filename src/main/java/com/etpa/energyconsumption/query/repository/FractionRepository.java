package com.etpa.energyconsumption.query.repository;

import com.etpa.energyconsumption.core.domain.Fraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FractionRepository extends JpaRepository<Fraction, Long> {
    Optional<Fraction> findByMonthAndProfile(String month, String profile);
}

