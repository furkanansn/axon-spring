package com.etpa.energyconsumption.command.aggregate;

import com.etpa.energyconsumption.command.commands.CreateFractionCommand;
import com.etpa.energyconsumption.command.commands.DeleteFractionCommand;
import com.etpa.energyconsumption.command.commands.UpdateFractionCommand;
import com.etpa.energyconsumption.core.event.FractionCreatedEvent;
import com.etpa.energyconsumption.core.event.FractionDeletedEvent;
import com.etpa.energyconsumption.core.event.FractionUpdatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Aggregate
public class FractionAggregate {
    @AggregateIdentifier
    private String id;
    private Long internalId;
    private String month;
    private String profile;
    private double frac;

    @CommandHandler
    public FractionAggregate(CreateFractionCommand createFractionCommand){
        final FractionCreatedEvent fractionCreatedEvent = FractionCreatedEvent.create(createFractionCommand);
        AggregateLifecycle.apply(fractionCreatedEvent);
    }

    @CommandHandler
    public FractionAggregate(UpdateFractionCommand updateFractionCommand){
        final FractionUpdatedEvent fractionUpdatedEvent = FractionUpdatedEvent.update(updateFractionCommand);
        AggregateLifecycle.apply(fractionUpdatedEvent);
    }

    @CommandHandler
    public FractionAggregate(DeleteFractionCommand deleteFractionCommand){
        final FractionDeletedEvent fractionDeletedEvent = FractionDeletedEvent.delete(deleteFractionCommand);
        AggregateLifecycle.apply(fractionDeletedEvent);
    }

    @EventSourcingHandler
    public void on(FractionCreatedEvent fractionCreatedEvent){
        this.id = fractionCreatedEvent.getId();
        this.month = fractionCreatedEvent.getMonth();
        this.profile = fractionCreatedEvent.getProfile();
        this.frac = fractionCreatedEvent.getFrac();
    }

    @EventSourcingHandler
    public void on(FractionUpdatedEvent fractionUpdatedEvent){
        this.id = String.valueOf(fractionUpdatedEvent.getId());
        this.internalId = fractionUpdatedEvent.getInternalId();
        this.month = fractionUpdatedEvent.getMonth();
        this.profile = fractionUpdatedEvent.getProfile();
        this.frac = fractionUpdatedEvent.getFrac();
    }

    @EventSourcingHandler
    public void on(FractionDeletedEvent fractionDeletedEvent){
        this.id = fractionDeletedEvent.getId();
        this.internalId = fractionDeletedEvent.getInternalId();
    }
}
