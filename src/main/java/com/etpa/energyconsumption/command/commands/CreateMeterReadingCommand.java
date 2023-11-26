package com.etpa.energyconsumption.command.commands;

import com.etpa.energyconsumption.command.dto.CreateMeterReadingRequestModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class CreateMeterReadingCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String meterId;
    private final String month;
    private final String profile;
    private final double meterReadingValue;

    public static CreateMeterReadingCommand create(String id, CreateMeterReadingRequestModel createMeterReadingRequestModel){
        return CreateMeterReadingCommand.builder()
                .id(id)
                .meterId(createMeterReadingRequestModel.getMeterId())
                .month(createMeterReadingRequestModel.getMonth())
                .profile(createMeterReadingRequestModel.getProfile())
                .meterReadingValue(createMeterReadingRequestModel.getMeterReading())
                .build();
    }
}
