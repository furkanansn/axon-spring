package com.etpa.energyconsumption.command.dto;



import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateFractionRequestModel {
        @NotNull
        private Long id;
        @NotEmpty
        private String month;
        @NotEmpty
        private String profile;
        @NotNull
        private Double frac;
}
