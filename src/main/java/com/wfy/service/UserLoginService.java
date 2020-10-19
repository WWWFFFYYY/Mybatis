package com.wfy.service;

import com.wfy.model.User;

public interface UserLoginService {

    User getLoginUser(User user);

    void registerUser(User user);
}
