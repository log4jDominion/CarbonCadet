package com.bitcamp.cadet.carbon.cadet.service;

import com.bitcamp.cadet.carbon.cadet.dao.DbDaoImpl;
import com.bitcamp.cadet.carbon.cadet.entities.ResponsePojo;
import com.bitcamp.cadet.carbon.cadet.entities.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    DbDaoImpl dao;

    public int updatePledge(String userId, String pledge) {
        return dao.updatePledge(userId, pledge);
    }

    public UserPojo checkAndInsertUser(UserPojo user) {
        List<UserPojo> userPojoList = dao.getAllInfoUser(user.getUserId());

        if (userPojoList.isEmpty()) {
            dao.insertUser(user);
            return user;
        } else {
            return userPojoList.get(0);
        }
    }

    public int updateUserInfo(UserPojo user) {
        return dao.updateUserInfo(user);
    }

}
