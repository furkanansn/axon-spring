package com.etpa.energyconsumption.query.handler;


import com.etpa.energyconsumption.query.ConsumptionQuery;
import com.etpa.energyconsumption.query.service.impl.EnergyQueryServiceImpl;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumptionQueryHandler {
    private final EnergyQueryServiceImpl energyQueryService;

    public ConsumptionQueryHandler(EnergyQueryServiceImpl energyQueryService){
        this.energyQueryService = energyQueryService;
    }

    @QueryHandler
    public double consumeEnergy(ConsumptionQuery consumptionQuery) {
        return energyQueryService.getConsumptionForMonth(consumptionQuery.getMeterId(),consumptionQuery.getMonth());
    }
}
