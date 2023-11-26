package com.etpa.energyconsumption.core.domain;

import com.etpa.energyconsumption.common.model.AbstractEntity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeterReading extends AbstractEntity {
    @Column(name = "external_meter_id",nullable = false)
    private String meterId;

    @Column(name = "profile",nullable = false)
    private String profile;

    @Column(name = "month",nullable = false)
    private String month;

    @Column(name = "meter_reading",nullable = false)
    private double meterReading;
}

