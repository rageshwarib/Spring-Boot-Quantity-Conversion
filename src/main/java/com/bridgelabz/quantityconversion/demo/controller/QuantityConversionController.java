package com.bridgelabz.quantityconversion.demo.controller;

import com.bridgelabz.quantityconversion.demo.QuantityType;
import com.bridgelabz.quantityconversion.demo.Unit;
import com.bridgelabz.quantityconversion.demo.dto.UnitDto;
import com.bridgelabz.quantityconversion.demo.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class QuantityConversionController {
    @Autowired
    IQuantityConversionService quantityConversionService;
    @GetMapping("/quantity")
    public ResponseEntity<List<QuantityType>> getQuantity() {
        return new ResponseEntity<>(quantityConversionService.getQuantity(), HttpStatus.OK);
    }
    @GetMapping("/quantity/{quantityType}")
    public ResponseEntity<List<Unit>> getUnits(@PathVariable QuantityType quantityType){
        return new ResponseEntity<>(quantityConversionService.getUnits(quantityType), HttpStatus.OK);
    }
    @PostMapping("/conversion")
    public ResponseEntity getConversion(@RequestBody UnitDto unitDto){
        return new ResponseEntity<>(quantityConversionService.getConversion(unitDto), HttpStatus.OK);
    }

}
