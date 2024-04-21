package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ElectricityPojo {

    private String device;

    private String  source;
    private String load;
    private String duration;
    private String efficiency;

}
