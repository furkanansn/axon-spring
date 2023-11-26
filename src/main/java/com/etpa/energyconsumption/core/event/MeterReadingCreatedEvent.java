package com.etpa.energyconsumption.core.event;

import com.etpa.energyconsumption.command.commands.CreateMeterReadingCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MeterReadingCreatedEvent {
    private final String id;
    private final String meterId;
    private final String month;
    private final String profile;
    private final double meterReadingValue;

    public static MeterReadingCreatedEvent create(CreateMeterReadingCommand createMeterReadingCommand){
        return MeterReadingCreatedEvent.builder()
                .id(createMeterReadingCommand.getId())
                .meterId(createMeterReadingCommand.getMeterId())
                .month(createMeterReadingCommand.getMonth())
                .profile(createMeterReadingCommand.getProfile())
                .meterReadingValue(createMeterReadingCommand.getMeterReadingValue())
                .build();
    }
}
