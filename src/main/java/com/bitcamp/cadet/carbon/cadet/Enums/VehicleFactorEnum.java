package com.bitcamp.cadet.carbon.cadet.Enums;

public enum VehicleFactorEnum {

    CAR("0.4"), EV("0.2"), PICKUP_TRUCK("0.681"), BUS("0.299"), TRAIN("0.177"), BIKE("0.33");

    public final String label;

    private VehicleFactorEnum(String label) {
        this.label = label;
    }
}
