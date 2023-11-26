package com.etpa.energyconsumption.core.event;

import com.etpa.energyconsumption.command.commands.UpdateMeterReadingCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MeterReadingUpdatedEvent {
    private final String id;
    private final Long internalId;
    private final String meterId;
    private final String month;
    private final String profile;
    private final double meterReadingValue;

    public static MeterReadingUpdatedEvent update(UpdateMeterReadingCommand updateMeterReadingCommand){
        return MeterReadingUpdatedEvent.builder()
                .id(updateMeterReadingCommand.getId())
                .internalId(updateMeterReadingCommand.getInternalId())
                .meterId(updateMeterReadingCommand.getMeterId())
                .month(updateMeterReadingCommand.getMonth())
                .profile(updateMeterReadingCommand.getProfile())
                .meterReadingValue(updateMeterReadingCommand.getMeterReadingValue())
                .build();
    }
}
