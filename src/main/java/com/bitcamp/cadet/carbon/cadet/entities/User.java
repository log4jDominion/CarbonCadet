package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class User implements Serializable {


    private Long userId;

    private String userName;

    private String userRole;

    private String lastFootprint;
}
