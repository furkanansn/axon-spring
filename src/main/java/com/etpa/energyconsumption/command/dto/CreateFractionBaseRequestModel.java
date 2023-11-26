package com.etpa.energyconsumption.command.dto;



import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CreateFractionBaseRequestModel {
        @NotEmpty
        private String profile;
        @NotEmpty
        private List<FractionProfileModel> fractionProfileModelList;
}
