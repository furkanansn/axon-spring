package com.etpa.energyconsumption.config;

import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnapshotConfiguration {
    final Integer SNAPSHOT_TRIGGER_COUNT = 10;
    @Bean(name = "energySnapshotStrategy")
    public SnapshotTriggerDefinition productSnapshotStrategy(Snapshotter snapshotter) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, SNAPSHOT_TRIGGER_COUNT);
    }
}
