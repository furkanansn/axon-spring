package com.etpa.energyconsumption.command.handler;

import com.etpa.energyconsumption.command.service.impl.MeterReadingCommandServiceImpl;
import com.etpa.energyconsumption.core.event.MeterReadingCreatedEvent;
import com.etpa.energyconsumption.core.event.MeterReadingDeletedEvent;
import com.etpa.energyconsumption.core.event.MeterReadingUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class MeterReadingEventHandler {
    private final MeterReadingCommandServiceImpl meterReadingCommandService;

    public MeterReadingEventHandler(MeterReadingCommandServiceImpl meterReadingCommandService){
        this.meterReadingCommandService = meterReadingCommandService;
    }

    @EventHandler
    public void on(MeterReadingCreatedEvent meterReadingCreatedEvent){
        meterReadingCommandService.saveMeterReading(meterReadingCreatedEvent);
    }

    @EventHandler
    public void on(MeterReadingUpdatedEvent meterReadingUpdatedEvent){
        meterReadingCommandService.updateMeterReading(meterReadingUpdatedEvent);
    }

    @EventHandler
    public void on(MeterReadingDeletedEvent meterReadingDeletedEvent){
        meterReadingCommandService.deleteMeterReading(meterReadingDeletedEvent);
    }
}
