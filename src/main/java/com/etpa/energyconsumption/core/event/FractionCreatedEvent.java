package com.etpa.energyconsumption.core.event;

import com.etpa.energyconsumption.command.commands.CreateFractionCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class FractionCreatedEvent {
    private  String id;
    private  String month;
    private  String profile;
    private  double frac;

    public static FractionCreatedEvent create(CreateFractionCommand createFractionCommand){
        return FractionCreatedEvent.builder()
                .id(createFractionCommand.getId())
                .month(createFractionCommand.getMonth())
                .profile(createFractionCommand.getProfile())
                .frac(createFractionCommand.getFrac())
                .build();
    }
}
