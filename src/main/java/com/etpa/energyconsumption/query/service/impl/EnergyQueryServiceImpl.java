package com.etpa.energyconsumption.query.service.impl;

import com.etpa.energyconsumption.core.domain.MeterReading;
import com.etpa.energyconsumption.core.enums.MonthEnum;
import com.etpa.energyconsumption.query.repository.FractionRepository;
import com.etpa.energyconsumption.query.repository.MeterReadingRepository;
import com.etpa.energyconsumption.query.service.EnergyQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyQueryServiceImpl implements EnergyQueryService {
    private final FractionRepository fractionRepository;
    private final MeterReadingRepository meterReadingRepository;

    public EnergyQueryServiceImpl(FractionRepository fractionRepository, MeterReadingRepository meterReadingRepository) {
        this.fractionRepository = fractionRepository;
        this.meterReadingRepository = meterReadingRepository;
    }

    @Override
    public double getConsumptionForMonth(String meterId, String month) {
        List<MeterReading> readings = meterReadingRepository.findByMeterId(meterId);
        double totalConsumption = 0.0;

        MonthEnum targetMonth = MonthEnum.valueOf(month);

        for (MeterReading currentReading : readings) {
            if (MonthEnum.valueOf(currentReading.getMonth()) == targetMonth) {

                // Fetch the previous month's reading from the database
                String previousMonth = MonthEnum.values()[targetMonth.ordinal() - 1].name();

                MeterReading previousReading = meterReadingRepository.findByMeterIdAndMonth(meterId, previousMonth)
                        .orElseThrow(() -> new RuntimeException("Previous month's reading not found"));

                double fraction = fractionRepository.findByMonthAndProfile(month, currentReading.getProfile())
                        .orElseThrow(() -> new RuntimeException("Fraction not found")).getFrac();

                double expectedConsumption = previousReading.getMeterReading() * fraction;
                double actualConsumption = currentReading.getMeterReading() - previousReading.getMeterReading();

                if (actualConsumption < (expectedConsumption * 0.75) || actualConsumption > (expectedConsumption * 1.25)) {
                    throw new RuntimeException("Consumption validation failed for meter: " + meterId + ", month: " + month);
                }

                totalConsumption += actualConsumption;

            }
        }
        return totalConsumption;
    }
}
