package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TravelPojo {

    private String vehicle;

    private String distance;
}
