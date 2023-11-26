package com.etpa.energyconsumption.query.service;

public interface EnergyQueryService {
    double getConsumptionForMonth(String meterId, String month);
}
