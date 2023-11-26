package com.etpa.energyconsumption.command.service.impl;

import com.etpa.energyconsumption.command.service.MeterReadingCommandService;
import com.etpa.energyconsumption.core.domain.MeterReading;
import com.etpa.energyconsumption.core.event.*;
import com.etpa.energyconsumption.query.repository.MeterReadingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MeterReadingCommandServiceImpl implements MeterReadingCommandService {
    private final MeterReadingRepository meterReadingRepository;

    public MeterReadingCommandServiceImpl(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }
    @Override
    public void saveMeterReading(MeterReadingCreatedEvent meterReadingCreatedEvent) {
        MeterReading meterReading = new MeterReading();
        meterReading.setMeterId(meterReadingCreatedEvent.getMeterId());
        meterReading.setProfile(meterReadingCreatedEvent.getProfile());
        meterReading.setMonth(meterReadingCreatedEvent.getMonth());
        meterReading.setMeterReading(meterReadingCreatedEvent.getMeterReadingValue());
        meterReadingRepository.save(meterReading);
    }

    @Override
    public void updateMeterReading(MeterReadingUpdatedEvent meterReadingUpdatedEvent) {
        Optional<MeterReading> optionalMeterReading = meterReadingRepository.findById(meterReadingUpdatedEvent.getInternalId());
        optionalMeterReading.ifPresent(meterReading -> {
            meterReading.setMeterId(meterReadingUpdatedEvent.getMeterId());
            meterReading.setProfile(meterReadingUpdatedEvent.getProfile());
            meterReading.setMonth(meterReadingUpdatedEvent.getMonth());
            meterReading.setMeterReading(meterReadingUpdatedEvent.getMeterReadingValue());
            meterReadingRepository.save(meterReading);
        });
    }

    @Override
    public void deleteMeterReading(MeterReadingDeletedEvent meterReadingDeletedEvent) {
        Optional<MeterReading> optionalMeterReading = meterReadingRepository.findById(meterReadingDeletedEvent.getInternalId());
        optionalMeterReading.ifPresent(meterReading -> {
            meterReading.setDeletedDate(new Date());
            meterReadingRepository.save(meterReading);
        });
    }
}
