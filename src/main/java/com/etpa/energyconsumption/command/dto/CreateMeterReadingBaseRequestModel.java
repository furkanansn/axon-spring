package com.etpa.energyconsumption.command.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CreateMeterReadingBaseRequestModel {
    @NotEmpty
    private List<CreateMeterReadingRequestModel> createMeterReadingRequestModelList;
}
