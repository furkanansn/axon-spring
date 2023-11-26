package com.etpa.energyconsumption.command.handler;

import com.etpa.energyconsumption.command.service.impl.FractionCommandServiceImpl;
import com.etpa.energyconsumption.core.event.FractionCreatedEvent;
import com.etpa.energyconsumption.core.event.FractionDeletedEvent;
import com.etpa.energyconsumption.core.event.FractionUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class FractionEventHandler {
    private final FractionCommandServiceImpl energyCommandService;

    public FractionEventHandler(FractionCommandServiceImpl energyCommandService){
        this.energyCommandService = energyCommandService;
    }

    @EventHandler
    public void on(FractionCreatedEvent fractionCreatedEvent){
        energyCommandService.saveFraction(fractionCreatedEvent);
    }

    @EventHandler
    public void on(FractionUpdatedEvent fractionUpdatedEvent){
        energyCommandService.updateFraction(fractionUpdatedEvent);
    }

    @EventHandler
    public void on(FractionDeletedEvent fractionDeletedEvent){
        energyCommandService.deleteFraction(fractionDeletedEvent);
    }
}
