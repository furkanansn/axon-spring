package com.etpa.energyconsumption.command.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateMeterReadingRequestModel {
    @NotNull
    private Long id;
    @NotEmpty
    private String meterId;
    @NotEmpty
    private String profile;
    @NotEmpty
    private String month;
    @NotNull
    private Double meterReading;
}
