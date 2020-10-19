package com.wfy.test;

import com.wfy.dao.UserMapper;
import com.wfy.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 用户测试类
 *
 * @author jacky
 * @date 2020年 09月02日 09:32:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test  //用户登录验证
    public void testUserLogin(){
        User user = new User();
        user.setName("admin");
        user.setPassword("11");
        User user2 = userMapper.getLoginUser(user);
        System.out.println(user2);
    }

    @Test  //注册用户
    public void testRegister(){
        User user  = new User();
        user.setName("wfy");
        user.setPassword("123");
        userMapper.registerUser(user);
    }

    @Test  //修改用户
    public void updateUser(){
        User user  = new User();
        user.setUserId(3);
        user.setName("wfyu");
        user.setPassword("123456");
        userMapper.updateUser(user);
    }

    @Test  //删除用户
    public void deleteUser(){
        User user = new User();
        user.setUserId(3);
        userMapper.deleteUser(user);
    }

    @Test
   public void selectAll(){
        List<User> userList = userMapper.getUserList();
        for(User u : userList){
            System.out.println(u);
        }
    }
}