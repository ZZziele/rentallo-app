package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import com.sda.rentalloapp.dto.ConfigItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/")
public class UiConfigController {
    @GetMapping("/fuel-types")
    public List<ConfigItem<String,String>> getFuelTypes(){

        return Arrays.stream( FuelType.values())
                .map(fuelType -> new ConfigItem<>(fuelType.name(),fuelType.fuelDescription()))
                .toList();
    }


    @GetMapping("/body-types")
    public List<ConfigItem<String,String>> getBodyTypes(){

        return Arrays.stream( BodyType.values())
                .map(bodyType -> new ConfigItem<>(bodyType.name(),bodyType.description()))
                .toList();
    }


    @GetMapping("/engine-types")
    public List<ConfigItem<String,String>> getEngineTypes(){

        return Arrays.stream( EngineType.values())
                .map(engineTypes -> new ConfigItem<>(engineTypes.name(),engineTypes.description()))
                .toList();
    }
}
