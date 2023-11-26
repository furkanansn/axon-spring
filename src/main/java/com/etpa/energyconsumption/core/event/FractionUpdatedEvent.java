package com.etpa.energyconsumption.core.event;

import com.etpa.energyconsumption.command.commands.UpdateFractionCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class FractionUpdatedEvent {
    private  String id;
    private  Long internalId;
    private  String month;
    private  String profile;
    private  double frac;

    public static FractionUpdatedEvent update(UpdateFractionCommand updateFractionCommand){
        return FractionUpdatedEvent.builder()
                .id(updateFractionCommand.getId())
                .internalId(updateFractionCommand.getInternalId())
                .month(updateFractionCommand.getMonth())
                .profile(updateFractionCommand.getProfile())
                .frac(updateFractionCommand.getFrac())
                .build();
    }
}
