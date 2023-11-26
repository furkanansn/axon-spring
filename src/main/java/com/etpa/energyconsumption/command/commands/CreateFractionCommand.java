package com.etpa.energyconsumption.command.commands;


import com.etpa.energyconsumption.command.dto.CreateFractionRequestModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class CreateFractionCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String month;
    private final String profile;
    private final double frac;

    public static CreateFractionCommand create(String id, CreateFractionRequestModel createFractionRequestModel){
        return CreateFractionCommand.builder()
                .id(id)
                .month(createFractionRequestModel.getMonth())
                .profile(createFractionRequestModel.getProfile())
                .frac(createFractionRequestModel.getFrac())
                .build();
    }
}
