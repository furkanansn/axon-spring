package com.etpa.energyconsumption.command.commands;

import com.etpa.energyconsumption.command.dto.UpdateMeterReadingRequestModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class UpdateMeterReadingCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final Long internalId;
    private final String meterId;
    private final String month;
    private final String profile;
    private final double meterReadingValue;

    public static UpdateMeterReadingCommand update(String id, UpdateMeterReadingRequestModel updateMeterReadingRequestModel){
        return UpdateMeterReadingCommand.builder()
                .id(id)
                .internalId(updateMeterReadingRequestModel.getId())
                .meterId(updateMeterReadingRequestModel.getMeterId())
                .month(updateMeterReadingRequestModel.getMonth())
                .profile(updateMeterReadingRequestModel.getProfile())
                .meterReadingValue(updateMeterReadingRequestModel.getMeterReading())
                .build();
    }
}
