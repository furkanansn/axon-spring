package com.etpa.energyconsumption.query.repository;

import com.etpa.energyconsumption.core.domain.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
    List<MeterReading> findByMeterId(String meterId);
    Optional<MeterReading> findByMeterIdAndMonth(String meterId, String month);
}

