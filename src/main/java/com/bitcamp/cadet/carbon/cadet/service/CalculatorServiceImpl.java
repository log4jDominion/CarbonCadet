package com.bitcamp.cadet.carbon.cadet.service;

import com.bitcamp.cadet.carbon.cadet.Enums.EmissionFactorEnums;
import com.bitcamp.cadet.carbon.cadet.Enums.FoodFactorEnum;
import com.bitcamp.cadet.carbon.cadet.Enums.VehicleFactorEnum;
import com.bitcamp.cadet.carbon.cadet.Enums.WaterSourceEnum;
import com.bitcamp.cadet.carbon.cadet.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl {

    public ResponsePojo calculateFootprint(CalculatorPojo calcPojo) {
        Long totalFootprint = calcElectricityFootprint(calcPojo)
                + calcWaterFootprint(calcPojo)
                + calcTravelFootprint(calcPojo)
                + calcFoodFootprint(calcPojo);

        String suggestion = "Suggestion";

        return new ResponsePojo(totalFootprint, suggestion);
    }

    private Long calcElectricityFootprint(CalculatorPojo calcPojo) {
        ElectricityPojo electricityInfo = calcPojo.getElectricity();
        Long emissionFactor = Long.parseLong(EmissionFactorEnums.valueOf(electricityInfo.getSource()).label);

        Long duration = Long.parseLong(electricityInfo.getDuration());
        Long load = Long.parseLong(electricityInfo.getLoad());
        Long efficiency = Long.parseLong(electricityInfo.getEfficiency());

        return (duration*load*emissionFactor)/efficiency;
    }

    private Long calcWaterFootprint(CalculatorPojo calcPojo) {
        WaterPojo waterInfo = calcPojo.getWater();
        Long srcEmissionFactor = Long.parseLong(WaterSourceEnum.valueOf(waterInfo.getSource()).label);

        Long amount = Long.parseLong(waterInfo.getQuantity());

        return srcEmissionFactor*amount;
    }

    private Long calcTravelFootprint(CalculatorPojo calcPojo) {
        TravelPojo travelInfo = calcPojo.getTravel();
        Long vehicleEmissionFactor = Long.parseLong(VehicleFactorEnum.valueOf(travelInfo.getVehicle()).label);

        Long distance = Long.parseLong(travelInfo.getDistance());

        return vehicleEmissionFactor*distance;
    }

    private Long calcFoodFootprint(CalculatorPojo calcPojo) {
        FoodPojo foodInfo = calcPojo.getFood();
        Long foodEmissionFactor = Long.parseLong(FoodFactorEnum.valueOf(foodInfo.getType()).label);

        Long consumption = Long.parseLong(foodInfo.getUsedAmt());

        return foodEmissionFactor*consumption;
    }
}
