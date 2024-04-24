package com.bitcamp.cadet.carbon.cadet.controller;

import com.bitcamp.cadet.carbon.cadet.entities.CalculatorPojo;
import com.bitcamp.cadet.carbon.cadet.entities.PledgePojo;
import com.bitcamp.cadet.carbon.cadet.entities.ResponsePojo;
import com.bitcamp.cadet.carbon.cadet.service.CalculatorServiceImpl;
import com.bitcamp.cadet.carbon.cadet.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CalculatorController {

    @Autowired
    CalculatorServiceImpl service;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/calculate")
    private ResponseEntity<ResponsePojo> calculateFootprint(@RequestBody CalculatorPojo calcObject) {
        return new ResponseEntity<>(service.calculateFootprint(calcObject), HttpStatus.OK);
    }

    @PostMapping("/updatePledge")
    private ResponseEntity<Integer> updatePledge(@RequestBody PledgePojo pledgePojo) {
        return new ResponseEntity<>(userService.updatePledge(pledgePojo.getUserId(), pledgePojo.getPledge()), HttpStatus.OK);
    }
}
