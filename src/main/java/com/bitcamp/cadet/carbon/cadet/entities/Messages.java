package com.bitcamp.cadet.carbon.cadet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Messages implements Serializable {
    private String role;
    private String content;
}
