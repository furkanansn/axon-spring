package com.etpa.energyconsumption.command.commands;

import com.etpa.energyconsumption.command.dto.UpdateFractionRequestModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class UpdateFractionCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final Long internalId;
    private final String month;
    private final String profile;
    private final double frac;

    public static UpdateFractionCommand update(String id, UpdateFractionRequestModel updateFractionRequestModel){
        return UpdateFractionCommand.builder()
                .id(id)
                .internalId(updateFractionRequestModel.getId())
                .month(updateFractionRequestModel.getMonth())
                .profile(updateFractionRequestModel.getProfile())
                .frac(updateFractionRequestModel.getFrac())
                .build();
    }
}
