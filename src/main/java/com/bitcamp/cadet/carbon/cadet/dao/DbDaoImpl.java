package com.bitcamp.cadet.carbon.cadet.dao;

import com.bitcamp.cadet.carbon.cadet.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user_info", new BeanPropertyRowMapper<>(User.class));
    }
}
