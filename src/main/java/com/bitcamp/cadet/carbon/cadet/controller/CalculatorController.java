package com.bitcamp.cadet.carbon.cadet.controller;

import com.bitcamp.cadet.carbon.cadet.entities.CalculatorPojo;
import com.bitcamp.cadet.carbon.cadet.entities.ResponsePojo;
import com.bitcamp.cadet.carbon.cadet.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    CalculatorServiceImpl service;

    @PostMapping("/calculate")
    private ResponseEntity<ResponsePojo> calculateFootprint(@RequestBody CalculatorPojo calcObject) {
        return new ResponseEntity<>(service.calculateFootprint(calcObject), HttpStatus.OK);
    }
}
