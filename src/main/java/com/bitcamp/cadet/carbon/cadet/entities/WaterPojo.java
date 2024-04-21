package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class WaterPojo  implements Serializable {

    private String temp;

    private String waterSource;

    private String quantity;
}
