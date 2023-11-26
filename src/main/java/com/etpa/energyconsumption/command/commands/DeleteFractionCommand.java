package com.etpa.energyconsumption.command.commands;

import com.etpa.energyconsumption.command.dto.DeleteFractionRequestModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class DeleteFractionCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final Long internalId;

    public static DeleteFractionCommand delete(String id, DeleteFractionRequestModel deleteFractionRequestModel){
        return DeleteFractionCommand.builder()
                .id(id)
                .internalId(deleteFractionRequestModel.getId())
                .build();
    }
}
