package com.etpa.energyconsumption.core.domain;

import com.etpa.energyconsumption.common.model.AbstractEntity;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="fractions")
public class Fraction extends AbstractEntity {

    @Column(name="month", nullable=false)
    private String month;

    @Column(name = "profile", nullable = false)
    private String profile;

    @Column(name = "frac", nullable = false)
    private double frac;
}
