package com.bridgelabz.quantityconversion.demo;

import com.bridgelabz.quantityconversion.demo.QuantityType;

public enum Unit {
    FEET(12.0, QuantityType.LENGTH), INCH(1.0,QuantityType.LENGTH), YARD(36.0, QuantityType.LENGTH), CM(0.4, QuantityType.LENGTH),
    GALLON(3.78,QuantityType.VOLUME), LITRE(1.0,QuantityType.VOLUME), MILLILITRE(0.001, QuantityType.VOLUME),
    TONNE(1000.0, QuantityType.WEIGHT), KILOGRAM(1.0, QuantityType.WEIGHT), GRAM(0.001, QuantityType.WEIGHT),
    FAHRENHEIT(5.0 / 9.0, QuantityType.TEMPERATURE), CELSIUS(9.0 / 5.0, QuantityType.TEMPERATURE);

    public final double conversionValue;
    public final QuantityType quantityType;

    Unit(double conversionValue, QuantityType quantityType){
        this.conversionValue = conversionValue;
        this.quantityType = quantityType;
    }
}
    //String json = gson.toJson(unitDto);