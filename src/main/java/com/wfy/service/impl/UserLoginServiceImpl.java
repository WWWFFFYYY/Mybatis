package com.wfy.service.impl;

import com.wfy.dao.UserMapper;
import com.wfy.model.User;
import com.wfy.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jacky
 * @date 2020年 09月02日 09:22:47
 */
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserMapper userMapper;

    public User getLoginUser(User user) {
        return userMapper.getLoginUser(user);
    }

    public void registerUser(User user) {
        userMapper.registerUser(user);
    }
}
