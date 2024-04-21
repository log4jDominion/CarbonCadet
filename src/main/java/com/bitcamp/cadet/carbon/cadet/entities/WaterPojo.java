package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WaterPojo {

    private String temp;

    private String source;

    private String quantity;
}
