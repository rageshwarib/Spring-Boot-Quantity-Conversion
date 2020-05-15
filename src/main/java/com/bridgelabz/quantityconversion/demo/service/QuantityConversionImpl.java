package com.bridgelabz.quantityconversion.demo.service;

import com.bridgelabz.quantityconversion.demo.QuantityType;
import com.bridgelabz.quantityconversion.demo.Unit;
import com.bridgelabz.quantityconversion.demo.dto.UnitDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityConversionImpl implements IQuantityConversionService {
    @Override
    public List<QuantityType> getQuantity() {
        return Arrays.asList(QuantityType.values());
    }

    @Override
    public List<Unit> getUnits(QuantityType quantityType) {
        return Arrays.stream(Unit.values()).filter(quantity -> quantity.quantityType.equals(quantityType))
                .collect(Collectors.toList());
    }

    @Override
    public double getConversion(UnitDto unitDto) {
       if (unitDto.getQuantityType().equals(unitDto.getFromUnit().quantityType) &&
               unitDto.getQuantityType().equals(unitDto.getToUnit().quantityType)) {
            return (unitDto.getFromUnit().conversionValue * unitDto.getValue()) / unitDto.getToUnit().conversionValue;
        }
       return 0;
    }


}
