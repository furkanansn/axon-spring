package com.etpa.energyconsumption.command.rest;

import com.etpa.energyconsumption.command.commands.CreateFractionCommand;


import com.etpa.energyconsumption.command.commands.DeleteFractionCommand;
import com.etpa.energyconsumption.command.commands.UpdateFractionCommand;
import com.etpa.energyconsumption.command.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static java.lang.Math.round;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fraction")
public class FractionCommandController {
    private final CommandGateway commandGateway;

    @PostMapping()
    public ResponseEntity<String> saveFraction(@RequestBody @Valid CreateFractionBaseRequestModel createFractionBaseRequestModel) {
        Double totalFractions = 0.0;
        for (FractionProfileModel fractionProfileModel : createFractionBaseRequestModel.getFractionProfileModelList()){
            totalFractions += fractionProfileModel.getFrac();
        }

        if(round(totalFractions) != 1){
            throw new RuntimeException("Fractions are not revelant");
        }

        for (FractionProfileModel fractionProfileModel : createFractionBaseRequestModel.getFractionProfileModelList()) {
            String id = String.valueOf(UUID.randomUUID());
            CreateFractionRequestModel createFractionRequestModel = new CreateFractionRequestModel();
            createFractionRequestModel.setFrac(fractionProfileModel.getFrac());
            createFractionRequestModel.setMonth(fractionProfileModel.getMonth());
            createFractionRequestModel.setProfile(createFractionBaseRequestModel.getProfile());
            CreateFractionCommand createFractionCommand = CreateFractionCommand.create(id, createFractionRequestModel);
            commandGateway.sendAndWait(createFractionCommand);
        }

        return ResponseEntity.ok("");
    }

    @PutMapping()
    public ResponseEntity<String> updateFraction(@RequestBody @Valid UpdateFractionRequestModel updateFractionRequestModel) {
        String id = String.valueOf(UUID.randomUUID());
        final UpdateFractionCommand updateFractionCommand = UpdateFractionCommand.update(id, updateFractionRequestModel);
        final var result = commandGateway.sendAndWait(updateFractionCommand);
        return ResponseEntity.ok((String) result);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteFraction(@RequestBody @Valid DeleteFractionRequestModel deleteFractionRequestModel) {
        String id = String.valueOf(UUID.randomUUID());
        final DeleteFractionCommand deleteFractionCommand = DeleteFractionCommand.delete(id,deleteFractionRequestModel);
        final var result = commandGateway.sendAndWait(deleteFractionCommand);
        return ResponseEntity.ok((String) result);
    }


}

