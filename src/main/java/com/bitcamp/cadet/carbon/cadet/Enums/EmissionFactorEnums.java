package com.bitcamp.cadet.carbon.cadet.Enums;

public enum EmissionFactorEnums {

    COAL("1.1"), NATURAL_GAS("0.5"), RENEWABLE("0.1");

    public final String label;

    private EmissionFactorEnums(String label) {
        this.label = label;
    }
}
