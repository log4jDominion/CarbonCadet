package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FoodPojo {

    private String type;

    private String boughtAmt;

    private String usedAmt;
}
