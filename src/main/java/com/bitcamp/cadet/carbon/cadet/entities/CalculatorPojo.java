package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CalculatorPojo {

    private ElectricityPojo electricity;

    private FoodPojo food;

    private TravelPojo travel;

    private WaterPojo water;
}
