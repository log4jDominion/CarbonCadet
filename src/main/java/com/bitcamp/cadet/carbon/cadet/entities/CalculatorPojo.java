package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class CalculatorPojo  implements Serializable {

    private UserPojo user;

    private ElectricityPojo electricity;

    private FoodPojo food;

    private TravelPojo travel;

    private WaterPojo water;
}
