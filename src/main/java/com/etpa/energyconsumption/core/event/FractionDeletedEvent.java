package com.etpa.energyconsumption.core.event;

import com.etpa.energyconsumption.command.commands.DeleteFractionCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class FractionDeletedEvent {
    private String id;
    private Long internalId;
    public static FractionDeletedEvent delete(DeleteFractionCommand deleteFractionCommand){
        return FractionDeletedEvent.builder()
                .id(deleteFractionCommand.getId())
                .internalId(deleteFractionCommand.getInternalId())
                .build();
    }
}
