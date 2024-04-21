package com.bitcamp.cadet.carbon.cadet.controller;


import com.bitcamp.cadet.carbon.cadet.dao.DbDaoImpl;
import com.bitcamp.cadet.carbon.cadet.entities.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private DbDaoImpl dao;

    @GetMapping("/users")
    public ResponseEntity<UserPojo> getAllUsers() {
        return new ResponseEntity(dao.getAllUsers(), HttpStatus.OK);
    }
}
