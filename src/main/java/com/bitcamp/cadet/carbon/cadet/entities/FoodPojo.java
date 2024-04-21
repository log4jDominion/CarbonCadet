package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class FoodPojo  implements Serializable {

    private String type;

    private String boughtAmt;

    private String usedAmt;
}
