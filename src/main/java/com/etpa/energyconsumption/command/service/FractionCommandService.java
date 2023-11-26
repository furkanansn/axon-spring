package com.etpa.energyconsumption.command.service;

import com.etpa.energyconsumption.core.event.FractionCreatedEvent;
import com.etpa.energyconsumption.core.event.FractionDeletedEvent;
import com.etpa.energyconsumption.core.event.FractionUpdatedEvent;

public interface FractionCommandService {
    void saveFraction(FractionCreatedEvent fractionCreatedEvent);
    void updateFraction(FractionUpdatedEvent fractionUpdatedEvent);
    void deleteFraction(FractionDeletedEvent fractionDeletedEvent);
}
