package com.bridgelabz.quantityconversion.demo.service;

import com.bridgelabz.quantityconversion.demo.QuantityType;
import com.bridgelabz.quantityconversion.demo.Unit;
import com.bridgelabz.quantityconversion.demo.dto.UnitDto;

import java.util.List;

public interface IQuantityConversionService {
    public List<QuantityType> getQuantity();
    public List<Unit> getUnits(QuantityType quantityType);
    public double getConversion(UnitDto unitDto);


}
