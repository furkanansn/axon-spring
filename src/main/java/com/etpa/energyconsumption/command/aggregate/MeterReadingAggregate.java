package com.etpa.energyconsumption.command.aggregate;

import com.etpa.energyconsumption.command.commands.CreateMeterReadingCommand;
import com.etpa.energyconsumption.command.commands.DeleteMeterReadingCommand;
import com.etpa.energyconsumption.command.commands.UpdateMeterReadingCommand;
import com.etpa.energyconsumption.core.event.MeterReadingCreatedEvent;
import com.etpa.energyconsumption.core.event.MeterReadingDeletedEvent;
import com.etpa.energyconsumption.core.event.MeterReadingUpdatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Aggregate
public class MeterReadingAggregate {
    @AggregateIdentifier
    private String id;
    private Long internalId;
    private String meterId;
    private String month;
    private String profile;
    private double meterReadingValue;

    @CommandHandler
    public MeterReadingAggregate(CreateMeterReadingCommand createMeterReadingCommand){
        final MeterReadingCreatedEvent meterReadingCreatedEvent = MeterReadingCreatedEvent.create(createMeterReadingCommand);
        AggregateLifecycle.apply(meterReadingCreatedEvent);
    }

    @CommandHandler
    public MeterReadingAggregate(UpdateMeterReadingCommand updateMeterReadingCommand){
        final MeterReadingUpdatedEvent meterReadingUpdatedEvent = MeterReadingUpdatedEvent.update(updateMeterReadingCommand);
        AggregateLifecycle.apply(meterReadingUpdatedEvent);
    }

    @CommandHandler
    public MeterReadingAggregate(DeleteMeterReadingCommand deleteMeterReadingCommand){
        final MeterReadingDeletedEvent meterReadingDeletedEvent = MeterReadingDeletedEvent.delete(deleteMeterReadingCommand);
        AggregateLifecycle.apply(meterReadingDeletedEvent);
    }

    @EventSourcingHandler
    public void on(MeterReadingCreatedEvent meterReadingCreatedEvent){
        this.id = meterReadingCreatedEvent.getId();
        this.meterId = meterReadingCreatedEvent.getMeterId();
        this.month = meterReadingCreatedEvent.getMonth();
        this.profile = meterReadingCreatedEvent.getProfile();
        this.meterReadingValue = meterReadingCreatedEvent.getMeterReadingValue();
    }

    @EventSourcingHandler
    public void on(MeterReadingUpdatedEvent meterReadingUpdatedEvent){
        this.id = meterReadingUpdatedEvent.getId();
        this.internalId = meterReadingUpdatedEvent.getInternalId();
        this.meterId = meterReadingUpdatedEvent.getMeterId();
        this.month = meterReadingUpdatedEvent.getMonth();
        this.profile = meterReadingUpdatedEvent.getProfile();
        this.meterReadingValue = meterReadingUpdatedEvent.getMeterReadingValue();
    }

    @EventSourcingHandler
    public void on(MeterReadingDeletedEvent meterReadingDeletedEvent){
        this.id = meterReadingDeletedEvent.getId();
        this.internalId = meterReadingDeletedEvent.getInternalId();
    }

}
