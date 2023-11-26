package com.etpa.energyconsumption.command.dto;



import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteFractionRequestModel {
        @NotNull
        private Long id;
}
