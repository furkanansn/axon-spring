package com.etpa.energyconsumption.command.service;


import com.etpa.energyconsumption.core.event.MeterReadingCreatedEvent;
import com.etpa.energyconsumption.core.event.MeterReadingDeletedEvent;
import com.etpa.energyconsumption.core.event.MeterReadingUpdatedEvent;

public interface MeterReadingCommandService {
    void saveMeterReading(MeterReadingCreatedEvent meterReadingCreatedEvent);
    void updateMeterReading(MeterReadingUpdatedEvent meterReadingUpdatedEvent);
    void deleteMeterReading(MeterReadingDeletedEvent meterReadingDeletedEvent);
}
