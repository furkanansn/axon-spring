package com.etpa.energyconsumption.core.event;

import com.etpa.energyconsumption.command.commands.DeleteMeterReadingCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MeterReadingDeletedEvent {
    private final String id;
    private Long internalId;

    public static MeterReadingDeletedEvent delete(DeleteMeterReadingCommand deleteMeterReadingCommand){
        return MeterReadingDeletedEvent.builder()
                .id(deleteMeterReadingCommand.getId())
                .internalId(deleteMeterReadingCommand.getInternalId())
                .build();
    }
}
