package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePojo implements Serializable {

    private long footprint;

    private String suggestion;
}
