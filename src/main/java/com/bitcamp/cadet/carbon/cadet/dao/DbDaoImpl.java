package com.bitcamp.cadet.carbon.cadet.dao;

import com.bitcamp.cadet.carbon.cadet.entities.UserPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbDaoImpl {

    Logger logger = LoggerFactory.getLogger(DbDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<UserPojo> getAllUsers() {
        logger.info("Started fetching all users info....");
        List<UserPojo> list = jdbcTemplate.query("select * from user_info", new BeanPropertyRowMapper<>(UserPojo.class));
        logger.info("Completed fetching all users info....");
        return list;
    }

    public List<UserPojo> getAllInfoUser(String userId) {
        logger.info("Started fetching users info for userId : {}....", userId);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("userId", userId);
        List<UserPojo> list = namedParameterJdbcTemplate.query("select * from user_info where user_id = :userId", param, new BeanPropertyRowMapper<>(UserPojo.class));
        logger.info("Completed fetching users info for userId : {}....", userId);
        return list;
    }

    public int insertUser(UserPojo userPojoInfo) {
        logger.info("Started inserting user for userId : {}..." ,userPojoInfo.getUserId());
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("userId", userPojoInfo.getUserId());
        param.addValue("userName", userPojoInfo.getUserName());
        param.addValue("userRole", userPojoInfo.getUserRole());
        int rowsUpdated = namedParameterJdbcTemplate.update("insert into public.user_info (user_id, user_name, user_role) values (:userId, :userName, :userRole)", param);
        logger.info("Completed inserting user for userId : {}, rowsUpdated : {}..." ,userPojoInfo.getUserId(), rowsUpdated);
        return rowsUpdated;

    }

    public int updateUserInfo(UserPojo userPojoInfo) {
        logger.info("Started updating userinfo for userId : {}...", userPojoInfo.getUserId());
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("userId", userPojoInfo.getUserId());
        param.addValue("userName", userPojoInfo.getUserName());
        param.addValue("userRole", userPojoInfo.getUserRole());
        param.addValue("lastFootprint", userPojoInfo.getLastFootprint());
        param.addValue("pledge", userPojoInfo.getPledge());

        int rowsUpdated = namedParameterJdbcTemplate.update("update public.user_info set user_name = :userName, user_role = :userRole, last_footprint = :lastFootprint, pledge = :pledge where user_id = :userId", param);
        logger.info("Completed updating userinfo for userId : {}, rowsUpdated : {}...", userPojoInfo.getUserId(), rowsUpdated);
        return rowsUpdated;
    }
}
