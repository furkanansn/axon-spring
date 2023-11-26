package com.etpa.energyconsumption.command.commands;

import com.etpa.energyconsumption.command.dto.DeleteMeterReadingRequestModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class DeleteMeterReadingCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final Long internalId;

    public static DeleteMeterReadingCommand delete(String id, DeleteMeterReadingRequestModel deleteMeterReadingRequestModel){
        return DeleteMeterReadingCommand.builder()
                .id(id)
                .internalId(deleteMeterReadingRequestModel.getId())
                .build();
    }
}
