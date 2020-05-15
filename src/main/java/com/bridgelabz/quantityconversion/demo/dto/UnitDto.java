package com.bridgelabz.quantityconversion.demo.dto;

import com.bridgelabz.quantityconversion.demo.QuantityType;
import com.bridgelabz.quantityconversion.demo.Unit;

public class UnitDto {
    QuantityType quantityType;
    Unit fromUnit;
    Unit toUnit;
    double value;

    public QuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(QuantityType quantityType) {
        this.quantityType = quantityType;
    }

    public Unit getToUnit() {
        return toUnit;
    }

    public void setToUnit(Unit toUnit) {
        this.toUnit = toUnit;
    }

    public Unit getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(Unit fromUnit) {
        this.fromUnit = fromUnit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
