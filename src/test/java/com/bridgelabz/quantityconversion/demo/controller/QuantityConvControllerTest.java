package com.bridgelabz.quantityconversion.demo.controller;

import com.bridgelabz.quantityconversion.demo.QuantityType;
import com.bridgelabz.quantityconversion.demo.Unit;
import com.bridgelabz.quantityconversion.demo.dto.UnitDto;
import com.bridgelabz.quantityconversion.demo.service.IQuantityConversionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityConvControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IQuantityConversionService quantityConversionService;
    Gson gson = new Gson();

    @Test
    void quantityConversion_shouldReturn_quantityType() throws Exception {
       List<QuantityType> quantityTypes = Arrays.asList(QuantityType.values());
        when(quantityConversionService.getQuantity()).thenReturn(quantityTypes);
        MvcResult mvcResult = mockMvc.perform(get("/quantity").
                contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String quantityList = mvcResult.getResponse().getContentAsString();
        List<QuantityType> quantityType = gson.fromJson(quantityList, new TypeToken<ArrayList<QuantityType>>(){}
           .getType());
        Assert.assertEquals(4, quantityType.size());
       // Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
    @Test
    void quantityConversion_shouldReturn_unitType() throws Exception {
        List<Unit> unit = Arrays.stream(Unit.values()).filter(quantity -> quantity.quantityType.equals(QuantityType.LENGTH))
                .collect(Collectors.toList());
        when(quantityConversionService.getUnits(QuantityType.LENGTH)).thenReturn(unit);
        MvcResult mvcResult = mockMvc.perform(get("/quantity/LENGTH").
                contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String unitList = mvcResult.getResponse().getContentAsString();
       List<Unit> units = gson.fromJson(unitList, new TypeToken<ArrayList<Unit>>(){}
               .getType());
        Assert.assertEquals(4, units.size());
    }

}
