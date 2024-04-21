package com.bitcamp.cadet.carbon.cadet.controller;


import com.bitcamp.cadet.carbon.cadet.dao.DbDaoImpl;
import com.bitcamp.cadet.carbon.cadet.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private DbDaoImpl dao;

    @GetMapping("/users")
    public ResponseEntity<User> getAllUsers() {
        return new ResponseEntity(dao.getAllUsers(), HttpStatus.OK);
    }
}
