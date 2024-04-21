package com.bitcamp.cadet.carbon.cadet.Enums;

public enum WaterSourceEnum {

    DESALINATED("15.1"), RECYCLED("10.1"), SURFACE_WATER("6.9"), IMPORTED("10.3");

    public final String label;

    private WaterSourceEnum(String label) {
        this.label = label;
    }
}
