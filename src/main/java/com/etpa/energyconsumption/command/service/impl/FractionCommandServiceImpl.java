package com.etpa.energyconsumption.command.service.impl;

import com.etpa.energyconsumption.command.service.FractionCommandService;
import com.etpa.energyconsumption.core.domain.Fraction;
import com.etpa.energyconsumption.core.event.FractionCreatedEvent;
import com.etpa.energyconsumption.core.event.FractionDeletedEvent;
import com.etpa.energyconsumption.core.event.FractionUpdatedEvent;
import com.etpa.energyconsumption.query.repository.FractionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FractionCommandServiceImpl implements FractionCommandService {
    private final FractionRepository fractionRepository;

    public FractionCommandServiceImpl(FractionRepository fractionRepository) {
        this.fractionRepository = fractionRepository;
    }

    @Override
    public void saveFraction(FractionCreatedEvent fractionCreatedEvent) {
        Fraction fraction = new Fraction();
        fraction.setMonth(fractionCreatedEvent.getMonth());
        fraction.setProfile(fractionCreatedEvent.getProfile());
        fraction.setFrac(fractionCreatedEvent.getFrac());
        fractionRepository.save(fraction);
    }

    @Override
    public void updateFraction(FractionUpdatedEvent fractionUpdatedEvent) {
        Optional<Fraction> optionalFraction = fractionRepository.findById(fractionUpdatedEvent.getInternalId());
        optionalFraction.ifPresent(fraction -> {
            fraction.setMonth(fractionUpdatedEvent.getMonth());
            fraction.setProfile(fractionUpdatedEvent.getProfile());
            fraction.setFrac(fractionUpdatedEvent.getFrac());
            fractionRepository.save(fraction);
        });
    }

    @Override
    public void deleteFraction(FractionDeletedEvent fractionDeletedEvent) {
       Optional<Fraction> optionalFraction = fractionRepository.findById(fractionDeletedEvent.getInternalId());
        optionalFraction.ifPresent(fraction -> {
            fraction.setDeletedDate(new Date());
            fractionRepository.save(fraction);
        });
    }


}
