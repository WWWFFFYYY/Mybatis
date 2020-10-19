package com.wfy.controller;

import com.wfy.model.User;
import com.wfy.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String getLogin(User user, Model model){
        User loginUser = userLoginService.getLoginUser(user);
        if(loginUser != null){
            return "success";
        }
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
}
