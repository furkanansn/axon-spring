package com.etpa.energyconsumption.command.rest;

import com.etpa.energyconsumption.command.commands.CreateMeterReadingCommand;


import com.etpa.energyconsumption.command.commands.DeleteMeterReadingCommand;
import com.etpa.energyconsumption.command.commands.UpdateMeterReadingCommand;
import com.etpa.energyconsumption.command.dto.CreateMeterReadingBaseRequestModel;
import com.etpa.energyconsumption.command.dto.CreateMeterReadingRequestModel;
import com.etpa.energyconsumption.command.dto.DeleteMeterReadingRequestModel;
import com.etpa.energyconsumption.command.dto.UpdateMeterReadingRequestModel;
import com.etpa.energyconsumption.core.enums.MonthEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meter-reading")
public class MeterReadingCommandController {
    private final CommandGateway commandGateway;


    @PostMapping()
    public ResponseEntity<String> saveMeterReading(@RequestBody @Valid CreateMeterReadingBaseRequestModel createMeterReadingBaseRequestModel) {
        createMeterReadingBaseRequestModel.getCreateMeterReadingRequestModelList().sort(
                Comparator.comparingInt(model -> MonthEnum.valueOf(model.getMonth()).getOrder())
        );

        Double previousReading = null;
        for (CreateMeterReadingRequestModel model : createMeterReadingBaseRequestModel.getCreateMeterReadingRequestModelList()) {
            if (previousReading != null && model.getMeterReading() > previousReading) {
                String id = String.valueOf(UUID.randomUUID());
                CreateMeterReadingCommand createMeterReadingCommand = CreateMeterReadingCommand.create(id, model);
                commandGateway.sendAndWait(createMeterReadingCommand);
            }

            previousReading = model.getMeterReading();
        }

        return ResponseEntity.ok((String) "");
    }

    @PutMapping()
    public ResponseEntity<String> updateMeterReading(@RequestBody @Valid UpdateMeterReadingRequestModel updateMeterReadingRequestModel) {
        String id = String.valueOf(UUID.randomUUID());
        final UpdateMeterReadingCommand updateMeterReadingCommand = UpdateMeterReadingCommand.update(id, updateMeterReadingRequestModel);
        final var result = commandGateway.sendAndWait(updateMeterReadingCommand);
        return ResponseEntity.ok((String) result);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteMeterReading(@RequestBody @Valid DeleteMeterReadingRequestModel deleteMeterReadingRequestModel) {
        String id = String.valueOf(UUID.randomUUID());
        final DeleteMeterReadingCommand deleteMeterReadingCommand = DeleteMeterReadingCommand.delete(id, deleteMeterReadingRequestModel);
        final var result = commandGateway.sendAndWait(deleteMeterReadingCommand);
        return ResponseEntity.ok((String) result);
    }
}

