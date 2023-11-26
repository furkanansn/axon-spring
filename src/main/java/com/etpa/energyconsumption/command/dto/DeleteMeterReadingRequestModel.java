package com.etpa.energyconsumption.command.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteMeterReadingRequestModel {
    @NotNull
    private Long id;
}
