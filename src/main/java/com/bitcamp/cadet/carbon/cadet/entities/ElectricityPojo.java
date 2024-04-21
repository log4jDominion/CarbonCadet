package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class ElectricityPojo implements Serializable {

    private String electricitySource;
    private String load;
    private String duration;
    private String efficiency;

}
