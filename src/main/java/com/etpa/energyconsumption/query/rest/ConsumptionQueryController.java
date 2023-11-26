package com.etpa.energyconsumption.query.rest;

import com.etpa.energyconsumption.query.ConsumptionQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/consumption")
public class ConsumptionQueryController {
    private final QueryGateway queryGateway;

    @GetMapping("/get-consumption")
    public Object getConsumption(ConsumptionQuery consumptionQuery) {
        return queryGateway.query(consumptionQuery, ResponseTypes.instanceOf(Object.class)).join();
    }
}

