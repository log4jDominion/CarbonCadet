package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class TravelPojo  implements Serializable {

    private String vehicle;

    private String distance;
}
