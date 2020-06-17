package com.ebupt.demo.service;

import com.ebupt.demo.dao.UserDao;
import com.ebupt.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /***
     * 变量（filed）注入
     * 构造器注入
     * set方法注入
     */
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getByName(String username){
        return userDao.findByUsername(username);
    }

    public boolean isExit(String username){
        User user = getByName(username);
        return null != user;
    }

    public User get(String username,String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userDao.save(user);
    }
}
