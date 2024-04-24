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

    @Autowired
    UserServiceImpl userService;

    @Autowired
    SuggestionServiceImpl suggestionService;

    public ResponsePojo calculateFootprint(CalculatorPojo calcPojo) {
        try {

            UserPojo userPojoInfo = userService.checkAndInsertUser(calcPojo.getUser());

            Double totalFootprint = calcElectricityFootprint(calcPojo)
                    + calcWaterFootprint(calcPojo)
                    + calcTravelFootprint(calcPojo)
                    + calcFoodFootprint(calcPojo);

            userPojoInfo.setLastFootprint(String.valueOf(totalFootprint));

            String suggestion = "Suggestion";
                    //suggestionService.generateSuggestion(calcPojo);

            userService.updateUserInfo(userPojoInfo);

            return new ResponsePojo(totalFootprint, suggestion, userPojoInfo.getPledge());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Double calcElectricityFootprint(CalculatorPojo calcPojo) {
        ElectricityPojo electricityInfo = calcPojo.getElectricity();
        Double emissionFactor = Double.parseDouble(EmissionFactorEnums.valueOf(electricityInfo.getElectricitySource()).label);

        Double duration = Double.parseDouble(electricityInfo.getDuration());
        Double load = Double.parseDouble(electricityInfo.getLoad());
        Double efficiency = Double.parseDouble(electricityInfo.getEfficiency());

        return (duration*load*emissionFactor)/efficiency;
    }

    private Double calcWaterFootprint(CalculatorPojo calcPojo) {
        WaterPojo waterInfo = calcPojo.getWater();
        Double srcEmissionFactor = Double.parseDouble(WaterSourceEnum.valueOf(waterInfo.getWaterSource()).label);

        Double amount = Double.parseDouble(waterInfo.getQuantity());

        return srcEmissionFactor*amount;
    }

    private Double calcTravelFootprint(CalculatorPojo calcPojo) {
        TravelPojo travelInfo = calcPojo.getTravel();
        Double vehicleEmissionFactor = Double.parseDouble(VehicleFactorEnum.valueOf(travelInfo.getVehicle()).label);

        Double distance = Double.parseDouble(travelInfo.getDistance());

        return vehicleEmissionFactor*distance;
    }

    private Double calcFoodFootprint(CalculatorPojo calcPojo) {
        FoodPojo foodInfo = calcPojo.getFood();
        Double foodEmissionFactor = Double.parseDouble(FoodFactorEnum.valueOf(foodInfo.getType()).label);

        Double consumption = Double.parseDouble(foodInfo.getUsedAmt());

        return foodEmissionFactor*consumption;
    }


}
