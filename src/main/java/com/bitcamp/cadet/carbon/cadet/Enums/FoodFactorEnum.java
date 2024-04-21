package com.bitcamp.cadet.carbon.cadet.Enums;

public enum FoodFactorEnum {

    VEGAN("0.56"), VEG("2.3"), NON_VEG("7.3"), PESC("4.1"), KETO("0.3");

    public final String label;

    private FoodFactorEnum(String label) {
        this.label = label;
    }
}
