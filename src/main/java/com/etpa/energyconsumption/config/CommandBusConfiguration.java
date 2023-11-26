package com.etpa.energyconsumption.config;

import com.etpa.energyconsumption.common.Constants;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.PropagatingErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandBusConfiguration {

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        configurer.registerListenerInvocationErrorHandler(Constants.Group.ENERGY, conf -> PropagatingErrorHandler.instance());
    }
}
