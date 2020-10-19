package com.wfy.test;

import com.wfy.dao.UserMapper;
import com.wfy.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author jacky
 * @date 2020年 09月03日 15:39:35
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserTest03 {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    UserMapper userMapper = null;

    SqlSession sqlSession =  null;

    @Before  //@Test运行前加载
    public void before(){
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After  //@Test运行后加载
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testGetUserListAnd(){
        User user = new User();
        user.setName("admin");
        user.setAge(20);
        List<User> userList = userMapper.getAllUserList(user);
        for(User u  : userList){
            System.out.println(u);
        }
    }

    @Test
    public void testGetUserListOr(){
        User user = new User();
        user.setName("admin");
        user.setAge(25);
        List<User> userList = userMapper.getAllUserList2(user);
        for(User u  : userList){
            System.out.println(u);
        }
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUserId(812);
        user.setName("chen");
        user.setAge(22);
        userMapper.updateUser2(user);
    }
}
