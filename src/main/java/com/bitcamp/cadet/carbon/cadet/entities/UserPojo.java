package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
public class UserPojo implements Serializable {


    private String userId;

    private String userName;

    private String userRole;

    private String pledge;

    private String lastFootprint;

    public UserPojo(String userId, String userName, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
    }
}
